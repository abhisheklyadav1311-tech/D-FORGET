import pytesseract
from PIL import Image
import os

class OCRService:
    @staticmethod
    def extract_text(file_path: str) -> str:
        """
        Extracts text from an image file using Tesseract OCR.
        """
        if not os.path.exists(file_path):
            raise FileNotFoundError(f"Image file not found at {file_path}")

        try:
            # Note: Tesseract must be installed on the system path
            text = pytesseract.image_to_string(Image.open(file_path))
            return text.strip()
        except Exception as e:
            print(f"Error during OCR: {e}")
            return ""
