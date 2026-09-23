import json
from typing import Dict, Any
from datetime import datetime, timedelta
from app.schemas.ai import AnalysisResult, ProposedTask

class AIService:
    """
    Service to handle AI analysis of extracted text.
    In a real production app, this would call Gemini, OpenAI, or a local LLM.
    For MVP, we implement a robust parsing structure that can be easily
    switched to a real API call.
    """

    @staticmethod
    async fun analyze_text(text: str, source_id: int) -> AnalysisResult:
        # Mock AI logic: In reality, we'd send 'text' to an LLM with a system prompt.
        # Here we simulate the extracted structured data.

        # Simple heuristic to make the mock "feel" real:
        is_urgent = "urgent" in text.lower() or "asap" in text.lower() or "immediately" in text.lower()
        has_deadline = "by" in text.lower() or "due" in text.lower() or "deadline" in text.lower()

        # Simulation of LLM output parsing
        summary = f"Extracted information from input. Subject seems to be {text[:30]}..."
        if len(text) > 100:
            summary = text[:100] + "..."

        # Mocked proposed task
        tasks = [
            ProposedTask(
                title=text[:40].strip() if len(text) > 5 else "New Task from AI",
                description=text,
                deadline=datetime.now() + timedelta(days=2) if has_deadline else None,
                priority="urgent" if is_urgent else "high" if has_deadline else "medium",
                category="assignment" if "assignment" in text.lower() else "other",
                subject="General"
            )
        ]

        return AnalysisResult(
            summary=summary,
            action_required=True,
            tasks=tasks,
            confidence_score=0.92,
            source_id=source_id
        )
