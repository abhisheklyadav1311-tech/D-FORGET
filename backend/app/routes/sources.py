import os
import shutil
import uuid
from fastapi import APIRouter, Depends, HTTPException, status, UploadFile, File
from sqlalchemy.orm import Session
from typing import List, Optional

from app.database import models
from app.database.connection import get_db
from app.schemas import source as schemas

router = APIRouter(
    prefix="/sources",
    tags=["sources"]
)

UPLOAD_DIR = "uploads"

@router.post("/", response_model=schemas.Source, status_code=status.HTTP_201_CREATED)
def create_source(
    type: str,
    file: Optional[UploadFile] = File(None),
    text: Optional[str] = None,
    db: Session = Depends(get_db)
):
    filename = None
    original_text = text

    if file:
        # Validate file type if needed
        ext = os.path.splitext(file.filename)[1]
        unique_filename = f"{uuid.uuid4()}{ext}"
        file_path = os.path.join(UPLOAD_DIR, unique_filename)

        with open(file_path, "wb") as buffer:
            shutil.copyfileobj(file.file, buffer)

        filename = unique_filename

    db_source = models.Source(
        type=type,
        filename=filename,
        original_text=original_text
    )
    db.add(db_source)
    db.commit()
    db.refresh(db_source)
    return db_source

@router.get("/", response_model=List[schemas.Source])
def read_sources(db: Session = Depends(get_db)):
    return db.query(models.Source).all()

@router.get("/{source_id}", response_model=schemas.Source)
def read_source(source_id: int, db: Session = Depends(get_db)):
    db_source = db.query(models.Source).filter(models.Source.id == source_id).first()
    if db_source is None:
        raise HTTPException(status_code=404, detail="Source not found")
    return db_source

@router.delete("/{source_id}", status_code=status.HTTP_204_NO_CONTENT)
def delete_source(source_id: int, db: Session = Depends(get_db)):
    db_source = db.query(models.Source).filter(models.Source.id == source_id).first()
    if db_source is None:
        raise HTTPException(status_code=404, detail="Source not found")

    # Delete file if exists
    if db_source.filename:
        file_path = os.path.join(UPLOAD_DIR, db_source.filename)
        if os.path.exists(file_path):
            os.remove(file_path)

    db.delete(db_source)
    db.commit()
    return None
