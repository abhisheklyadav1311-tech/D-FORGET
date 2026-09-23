import fitz  # PyMuPDF
import os

class PDFService:
    @staticmethod
    def extract_text(file_path: str) -> str:
        """
        Extracts text from a PDF file.
        If it's an image-based PDF, this will return empty or minimal text,
        which triggers the OCR fallback.
        """
        if not os.path.exists(file_path):
            raise FileNotFoundError(f"PDF file not found at {file_path}")

        text = ""
        try:
            with fitz.open(file_path) as doc:
                for page in doc:
                    text += page.get_text()
        except Exception as e:
            # Log error or handle appropriately
            print(f"Error extracting text from PDF: {e}")
            return ""

        return text.strip()
