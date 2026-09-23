from pydantic import BaseModel
from typing import List, Optional
from datetime import datetime

class ProposedTask(BaseModel):
    title: str
    description: Optional[str] = None
    deadline: Optional[datetime] = None
    priority: str = "medium"  # low, medium, high, urgent
    category: str = "other"
    subject: Optional[str] = None

class AnalysisResult(BaseModel):
    summary: str
    action_required: bool
    tasks: List[ProposedTask]
    confidence_score: float
    source_id: int
