from pydantic import BaseModel, ConfigDict
from datetime import datetime
from typing import Optional, List

class SourceBase(BaseModel):
    type: str  # text, image, screenshot, pdf
    filename: Optional[str] = None
    original_text: Optional[str] = None
    summary: Optional[str] = None

class SourceCreate(SourceBase):
    pass

class Source(SourceBase):
    id: int
    created_at: datetime

    model_config = ConfigDict(from_attributes=True)
