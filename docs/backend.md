# AI TASK ORGANIZER

## Backend Development Specification

**Version:** 1.0
**Stage:** Backend V1
**Purpose:** Master specification for building the backend with an AI coding IDE.

---

# 1. BACKEND OBJECTIVE

Build a simple, modular, local-first backend for an AI-powered task and reminder application.

The backend must:

* Manage tasks
* Manage reminders
* Store uploaded sources
* Accept text, images, screenshots, and PDFs
* Extract text from images using OCR
* Extract text from PDFs
* Analyze extracted content using an AI service
* Return structured AI results
* Validate AI output
* Allow the frontend to review AI-generated task proposals
* Store confirmed tasks
* Provide APIs for the future React frontend
* Be designed so it can later support an Android application

The backend must initially run locally and should require minimal or zero infrastructure cost.

---

# 2. IMPORTANT DEVELOPMENT RULE

Do NOT build the entire backend in one step.

Build it in phases.

Required order:

```text
Phase 1
Project setup
        ↓
Phase 2
Database
        ↓
Phase 3
Task API
        ↓
Phase 4
Source/file handling
        ↓
Phase 5
PDF/OCR processing
        ↓
Phase 6
AI service
        ↓
Phase 7
AI analysis pipeline
        ↓
Phase 8
Reminder system
        ↓
Phase 9
Testing and cleanup
```

Each phase must be working before starting the next phase.

Do not implement future functionality unless explicitly requested.

---

# 3. TECHNOLOGY STACK

Use only the following technologies for Backend V1.

## Programming Language

Python 3

## API Framework

FastAPI

## Server

Uvicorn

## Database

SQLite

## ORM

SQLAlchemy

## Data Validation

Pydantic

## Configuration

pydantic-settings / python-dotenv

## File Uploads

FastAPI multipart/form-data

## PDF Processing

PyMuPDF

Python package:

```text
pymupdf
```

## OCR

Tesseract OCR

Python integration:

```text
pytesseract
```

## HTTP Requests

httpx

## Testing

pytest

## Version Control

Git

GitHub

---

# 4. TECHNOLOGIES NOT REQUIRED

Do NOT introduce these unless explicitly requested:

* PostgreSQL
* MongoDB
* Redis
* Celery
* RabbitMQ
* Kubernetes
* Docker
* Microservices
* GraphQL
* Firebase
* AWS
* Complex authentication
* Cloud storage
* Message queues

The application is a local-first student project.

Keep the architecture simple.

---

# 5. BACKEND ARCHITECTURE

Use a modular monolithic architecture.

```text
React Frontend
       │
       │ HTTP / REST
       ▼
FastAPI Backend
       │
       ├───────────────┐
       │               │
       ▼               ▼
   Services         Database
       │             SQLite
       │
       ├── AI Service
       ├── OCR Service
       ├── PDF Service
       └── Reminder Service
```

Do NOT create microservices.

---

# 6. PROJECT STRUCTURE

Use this structure:

```text
backend/
│
├── app/
│   │
│   ├── main.py
│   │
│   ├── core/
│   │   └── config.py
│   │
│   ├── database/
│   │   ├── connection.py
│   │   └── models.py
│   │
│   ├── models/
│   │   ├── task.py
│   │   ├── reminder.py
│   │   └── source.py
│   │
│   ├── schemas/
│   │   ├── task.py
│   │   ├── reminder.py
│   │   ├── source.py
│   │   └── ai.py
│   │
│   ├── routes/
│   │   ├── tasks.py
│   │   ├── reminders.py
│   │   ├── sources.py
│   │   └── analysis.py
│   │
│   ├── services/
│   │   ├── ai_service.py
│   │   ├── ocr_service.py
│   │   ├── pdf_service.py
│   │   └── reminder_service.py
│   │
│   └── utils/
│
├── tests/
│
├── uploads/
│
├── .env
├── .gitignore
├── requirements.txt
└── README.md
```

If a simpler structure is more appropriate during Phase 1, do not create empty unnecessary files. Add modules as functionality is implemented.

---

# 7. DATABASE

Use SQLite.

Database file:

```text
app.db
```

Database URL should be configurable.

Example:

```text
sqlite:///./app.db
```

SQLAlchemy should manage database operations.

Do not scatter raw SQL throughout route files.

---

# 8. DATABASE MODELS

There are three primary entities:

```text
Task
Source
Reminder
```

---

# 9. TASK MODEL

Task fields:

```text
id
title
description
deadline
priority
category
subject
status
source_id
ai_generated
created_at
updated_at
completed_at
```

Recommended types:

```text
id              Integer / UUID
title           String
description     Text / nullable
deadline        DateTime / nullable
priority        String
category        String
subject         String / nullable
status          String
source_id       Foreign Key / nullable
ai_generated    Boolean
created_at      DateTime
updated_at      DateTime
completed_at    DateTime / nullable
```

---

# 10. TASK VALUES

## Priority

Allowed initial values:

```text
low
medium
high
urgent
```

## Status

Allowed initial values:

```text
pending
completed
archived
```

## Category

Initial values:

```text
assignment
exam
project
event
personal
college
study
other
```

Categories should remain flexible so custom categories can be added later.

---

# 11. SOURCE MODEL

A source represents the original material from which information was extracted.

Fields:

```text
id
type
filename
original_text
summary
created_at
```

Types:

```text
text
image
screenshot
pdf
```

A source can produce zero, one, or multiple tasks.

Relationship:

```text
Source
   │
   ├── Task
   ├── Task
   └── Task
```

Do NOT assume:

```text
1 source = 1 task
```

---

# 12. REMINDER MODEL

Fields:

```text
id
task_id
reminder_time
enabled
created_at
```

Relationship:

```text
Task
 │
 ├── Reminder
 ├── Reminder
 └── Reminder
```

One task may have multiple reminders.

---

# 13. PYDANTIC SCHEMAS

Create separate schemas for:

* Task creation
* Task update
* Task response
* Reminder creation
* Reminder update
* Source response
* AI analysis result

Do not return raw SQLAlchemy objects directly without proper response schemas.

---

# 14. TASK API

Implement:

```text
POST   /api/tasks
GET    /api/tasks
GET    /api/tasks/{id}
PUT    /api/tasks/{id}
DELETE /api/tasks/{id}
PATCH  /api/tasks/{id}/complete
```

---

# 15. CREATE TASK

Endpoint:

```text
POST /api/tasks
```

Accept:

```text
title
description
deadline
priority
category
subject
source_id
ai_generated
```

Validate all fields.

Return the created task.

---

# 16. GET TASKS

Endpoint:

```text
GET /api/tasks
```

Initially support:

* All tasks
* Pending tasks
* Completed tasks
* Overdue tasks
* Upcoming tasks

Use query parameters where appropriate.

Example:

```text
GET /api/tasks?status=pending
```

---

# 17. GET SINGLE TASK

Endpoint:

```text
GET /api/tasks/{id}
```

If the task does not exist:

Return:

```text
404 Not Found
```

with a clear error message.

---

# 18. UPDATE TASK

Endpoint:

```text
PUT /api/tasks/{id}
```

Allow editing:

* Title
* Description
* Deadline
* Priority
* Category
* Subject

Do not allow invalid status values.

---

# 19. DELETE TASK

Endpoint:

```text
DELETE /api/tasks/{id}
```

Delete the task safely.

Handle associated reminders appropriately.

A deleted task must not continue producing reminders.

---

# 20. COMPLETE TASK

Endpoint:

```text
PATCH /api/tasks/{id}/complete
```

Set:

```text
status = completed
completed_at = current timestamp
```

When a task is completed, active reminders should no longer trigger.

---

# 21. SOURCE API

Implement:

```text
POST /api/sources
GET /api/sources
GET /api/sources/{id}
DELETE /api/sources/{id}
```

The source system should support storing the original extracted content.

---

# 22. FILE HANDLING

Allowed initial file types:

```text
PNG
JPG
JPEG
WEBP
PDF
TXT
MD
```

Set a reasonable maximum upload size.

Validate file type before processing.

Never execute uploaded files.

Sanitize filenames.

Do not trust user-provided file extensions.

---

# 23. UPLOAD STORAGE

Initially store uploaded files locally:

```text
backend/uploads/
```

Do not introduce cloud storage.

Keep the file storage layer modular so it can later be replaced by cloud storage.

---

# 24. TEXT PROCESSING

For direct text input:

```text
User text
   ↓
Backend
   ↓
Clean text
   ↓
AI service
```

Do not unnecessarily run OCR on text.

---

# 25. PDF PROCESSING

Use PyMuPDF.

Flow:

```text
PDF
 ↓
PyMuPDF
 ↓
Extract text
 ↓
Clean text
 ↓
AI
```

If the PDF contains no extractable text:

Return an appropriate response.

Do not pretend the PDF was successfully analyzed.

OCR for scanned PDFs can be added later.

---

# 26. OCR PROCESSING

Use Tesseract OCR.

Flow:

```text
Image
 ↓
Tesseract
 ↓
Extracted text
 ↓
Clean text
 ↓
AI
```

Handle:

* Empty OCR output
* Poor image quality
* Unsupported image formats
* OCR errors

Return clear errors.

---

# 27. TEXT CLEANING

Before sending content to AI:

* Remove excessive whitespace.
* Normalize line breaks.
* Remove obvious OCR noise where safe.
* Preserve dates.
* Preserve important punctuation.
* Do not aggressively modify the original content.

Store the original extracted text separately.

---

# 28. AI SERVICE

Create:

```text
services/ai_service.py
```

The rest of the application should interact with:

```text
AIService
```

rather than directly calling a specific AI provider from route files.

Example conceptual interface:

```text
analyze(text)
```

This allows the AI provider to be changed later.

---

# 29. AI PROVIDER

For V1, use an external AI API.

Keep the provider implementation isolated.

The API key must be stored only in the backend environment.

Never expose it to the React frontend.

Never commit the API key to GitHub.

---

# 30. ENVIRONMENT VARIABLES

Use `.env`.

Example:

```text
AI_API_KEY=your_key
AI_MODEL=your_model
DATABASE_URL=sqlite:///./app.db
```

Do not hard-code secrets.

Add `.env` to `.gitignore`.

---

# 31. AI ANALYSIS OUTPUT

AI must return structured information.

Expected fields:

```text
title
description
summary
action_required
deadline
deadline_confidence
priority
category
subject
important_points
```

Example:

```json
{
  "title": "DBMS Assignment",
  "description": "Complete Units 1-5 and submit through Google Classroom.",
  "summary": "DBMS assignment must be submitted by September 18.",
  "action_required": true,
  "deadline": "2026-09-18T23:59:00",
  "deadline_confidence": "high",
  "priority": "high",
  "category": "assignment",
  "subject": "DBMS",
  "important_points": [
    "Complete Units 1-5",
    "Submit through Google Classroom"
  ]
}
```

---

# 32. AI RULES

The AI must:

1. Analyze only supplied content.
2. Never invent information.
3. Never invent deadlines.
4. Return null when information is unavailable.
5. Clearly indicate uncertainty.
6. Identify required actions.
7. Generate concise summaries.
8. Generate short actionable titles.
9. Return structured output.
10. Preserve factual accuracy.
11. Identify multiple actions when present.
12. Distinguish facts from inference.

---

# 33. DEADLINE CONFIDENCE

Allowed values:

```text
high
medium
low
none
```

Example:

Explicit:

```text
"Submit by September 18."

→ high
```

Ambiguous:

```text
"Submit before practical examinations."

→ medium/low
```

No deadline:

```text
deadline = null
deadline_confidence = none
```

The system must never silently convert an uncertain date into a confirmed deadline.

---

# 34. ACTION DETECTION

The AI must determine:

```text
action_required = true
```

only when the content requires an action.

Example:

```text
"Students must register before September 20."

action_required = true
```

Example:

```text
"College will remain closed on Monday."

action_required = false
```

Do not automatically create tasks for informational notices.

---

# 35. MULTIPLE ACTIONS

A single source can contain multiple actions.

Example:

```text
Register for exam by Sep 15.
Pay fee by Sep 17.
Download admit card by Sep 20.
```

The AI should eventually return:

```text
proposed_tasks[]
```

rather than only one task.

Architecture:

```text
Source
 ↓
AI Analysis
 ↓
0..N proposed tasks
```

Implement this cleanly when building the AI analysis phase.

---

# 36. ANALYSIS ENDPOINT

Create:

```text
POST /api/analyze
```

It should accept supported input.

Possible input:

```text
text
image
pdf
```

The backend determines the input type.

---

# 37. ANALYSIS PIPELINE

```text
                USER INPUT
                    │
       ┌────────────┼────────────┐
       │            │            │
      TEXT        IMAGE          PDF
       │            │            │
       │           OCR       PyMuPDF
       │            │            │
       └────────────┼────────────┘
                    ↓
              EXTRACTED TEXT
                    ↓
               TEXT CLEANING
                    ↓
                 AI SERVICE
                    ↓
             STRUCTURED JSON
                    ↓
             PYDANTIC VALIDATION
                    ↓
              PROPOSED RESULT
                    ↓
                FRONTEND
```

---

# 38. IMPORTANT: ANALYZE ≠ CREATE TASK

The `/api/analyze` endpoint should return a proposed result.

It should NOT automatically create a permanent task.

Correct flow:

```text
Upload
 ↓
Analyze
 ↓
AI proposal
 ↓
User reviews
 ↓
User edits if necessary
 ↓
User confirms
 ↓
POST /api/tasks
 ↓
Task stored
```

This protects against AI mistakes.

---

# 39. AI RESPONSE VALIDATION

Never trust raw AI output.

Use:

```text
AI
 ↓
Pydantic schema
 ↓
Validation
 ↓
Application logic
```

Invalid output should produce a controlled error.

Do not allow malformed AI data into the database.

---

# 40. REMINDER API

Implement:

```text
POST   /api/reminders
GET    /api/reminders
PUT    /api/reminders/{id}
DELETE /api/reminders/{id}
```

Each reminder must belong to a task.

---

# 41. REMINDER CREATION

Input:

```text
task_id
reminder_time
enabled
```

Validate:

* Task exists.
* Reminder time is valid.
* Reminder time is reasonable.
* Completed/deleted tasks cannot have active reminders.

---

# 42. REMINDER TYPES

Initial system should support exact reminder times.

Future system can support relative reminders:

```text
7 days before
3 days before
1 day before
2 hours before
30 minutes before
```

For V1, store the final calculated reminder timestamp.

---

# 43. REMINDER LOGIC

Example:

```text
Task deadline:
18 Sep 2026 11:59 PM

Reminder:
3 days before
```

Calculate:

```text
15 Sep 2026 11:59 PM
```

Store the reminder timestamp.

---

# 44. NOTIFICATION ARCHITECTURE

For the initial backend:

```text
Task
 ↓
Reminder
 ↓
Stored locally
```

Do not build a complicated cloud push-notification system.

For future Android:

```text
Backend
 ↓
Task synchronization
 ↓
Android local database
 ↓
Android local alarm/notification system
 ↓
User notification
```

The Android device should ultimately be responsible for local deadline notifications.

---

# 45. COMPLETED TASKS

When a task is completed:

```text
status = completed
completed_at = timestamp
```

All active reminders associated with the task should be disabled or ignored.

---

# 46. DATE AND TIME

Use timezone-aware datetime handling wherever possible.

The backend should receive or know the user's timezone.

Do not blindly assume UTC when calculating user reminders.

For V1 local development, timezone handling can be simplified, but the code should not make timezone-aware architecture impossible later.

---

# 47. ERROR HANDLING

Handle:

```text
400 Bad Request
404 Not Found
413 Payload Too Large
415 Unsupported Media Type
422 Validation Error
500 Internal Server Error
```

Return useful JSON error messages.

Example:

```json
{
  "error": "No readable text was found in the uploaded image."
}
```

Do not expose internal stack traces to the frontend.

---

# 48. SECURITY

Required:

* Validate file type.
* Limit file size.
* Sanitize filenames.
* Never execute uploaded files.
* Keep API keys server-side.
* Use `.env`.
* Do not commit secrets.
* Validate AI output.
* Validate database inputs.
* Avoid path traversal vulnerabilities.
* Do not trust client-provided metadata.

---

# 49. LOGGING

Add simple useful logging.

Log:

* API errors
* AI failures
* OCR failures
* PDF extraction failures
* File processing errors

Do NOT log:

* API keys
* Sensitive user content unnecessarily
* Authentication secrets

---

# 50. TESTING

Use pytest.

Tests should eventually cover:

## Database

* Create task
* Read task
* Update task
* Delete task
* Create reminder
* Create source

## API

* Task CRUD
* Source CRUD
* Reminder CRUD
* Analyze endpoint

## AI

* Valid structured output
* Invalid AI output
* Missing deadline
* Multiple tasks
* Action detection

## File processing

* Valid PDF
* Invalid PDF
* Valid image
* Empty OCR result
* Unsupported file

---

# 51. AI TEST CASES

Use these as baseline tests.

### Case 1 — Assignment

```text
Submit DBMS assignment by 18 September.
```

Expected:

```text
action_required = true
category = assignment
deadline = September 18
```

---

### Case 2 — Informational notice

```text
College will remain closed tomorrow.
```

Expected:

```text
action_required = false
```

---

### Case 3 — Exam

```text
Mid semester examinations begin on September 25.
```

Expected:

```text
category = exam
deadline/event date = September 25
```

Do not automatically create a task unless there is an action.

---

### Case 4 — Ambiguous

```text
Submit project before practical examinations.
```

Expected:

```text
deadline = uncertain/null
deadline_confidence != high
```

---

### Case 5 — Multiple actions

```text
Register for examination by September 15.
Pay examination fee by September 17.
Download admit card by September 20.
```

Expected:

```text
3 proposed tasks
```

---

# 52. API DOCUMENTATION

FastAPI should automatically provide:

```text
/docs
```

and:

```text
/redoc
```

Use these to manually test endpoints during development.

---

# 53. CORS

The future React frontend will run separately from FastAPI during development.

Configure CORS for the development frontend.

Do not use:

```text
allow_origins=["*"]
```

in a production configuration unless there is a deliberate reason.

Use environment-based configuration later.

---

# 54. CONFIGURATION

Create a central configuration system.

Example conceptual settings:

```text
DATABASE_URL
AI_API_KEY
AI_MODEL
UPLOAD_DIRECTORY
MAX_UPLOAD_SIZE
ALLOWED_ORIGINS
```

Do not scatter configuration values throughout the code.

---

# 55. API RESPONSE STYLE

Keep responses consistent.

Successful response:

```json
{
  "data": {}
}
```

or use a consistent direct-resource format.

Choose one convention and use it consistently.

Do not mix completely different response structures between endpoints.

---

# 56. SERVICE RESPONSIBILITIES

## `ai_service.py`

Responsible only for:

* Calling AI provider
* Sending analysis prompt
* Parsing structured response
* Returning AI result

It should not directly manipulate database records.

---

## `ocr_service.py`

Responsible only for:

* Receiving image
* Running OCR
* Returning extracted text

---

## `pdf_service.py`

Responsible only for:

* Reading PDF
* Extracting text
* Returning extracted text

---

## `reminder_service.py`

Responsible for:

* Reminder calculations
* Reminder validation
* Reminder state logic

---

# 57. ROUTE RESPONSIBILITIES

Routes should:

1. Receive HTTP request.
2. Validate request.
3. Call appropriate service.
4. Perform database operation.
5. Return response.

Do not put huge blocks of business logic directly inside route functions.

---

# 58. DATABASE RESPONSIBILITIES

Database layer should:

* Configure SQLite
* Create sessions
* Define models
* Handle relationships

Routes should not create database connections manually for every operation.

---

# 59. BACKEND DEVELOPMENT PHASES

## Phase 1 — Foundation

Checklist:

```text
□ Create backend folder
□ Create Python virtual environment
□ Install dependencies
□ Create FastAPI application
□ Create main.py
□ Start Uvicorn
□ Verify /docs
□ Create .env
□ Create .gitignore
□ Create README
```

Success:

```text
FastAPI server runs correctly.
```

---

# 60. Phase 2 — Database

```text
□ Configure SQLite
□ Configure SQLAlchemy
□ Create database connection
□ Create Task model
□ Create Source model
□ Create Reminder model
□ Initialize database
□ Test database
```

Success:

```text
Database can create/read/update/delete records.
```

---

# 61. Phase 3 — Task API

```text
□ POST /api/tasks
□ GET /api/tasks
□ GET /api/tasks/{id}
□ PUT /api/tasks/{id}
□ DELETE /api/tasks/{id}
□ PATCH /api/tasks/{id}/complete
□ Validation
□ Error handling
□ API tests
```

Success:

```text
Complete task CRUD works through /docs.
```

---

# 62. Phase 4 — Sources

```text
□ Source model
□ Source schema
□ Source API
□ Text source
□ Image source
□ PDF source
□ Local file storage
```

Success:

```text
Sources can be stored and retrieved.
```

---

# 63. Phase 5 — PDF

```text
□ Install PyMuPDF
□ PDF validation
□ PDF text extraction
□ Empty PDF handling
□ Extraction tests
```

Success:

```text
PDF → text works.
```

---

# 64. Phase 6 — OCR

```text
□ Install Tesseract
□ Install pytesseract
□ Image validation
□ OCR service
□ OCR error handling
□ OCR tests
```

Success:

```text
Image → OCR → text works.
```

---

# 65. Phase 7 — AI

```text
□ Create AI service abstraction
□ Configure AI provider
□ Create analysis prompt
□ Create Pydantic AI schema
□ Structured response
□ Validate response
□ Handle AI failures
□ Test analysis
```

Success:

```text
Text → AI → validated structured result.
```

---

# 66. Phase 8 — Unified Analysis

Implement:

```text
POST /api/analyze
```

Flow:

```text
Input
 ↓
Detect type
 ↓
Extract text
 ↓
Clean text
 ↓
AI
 ↓
Validate
 ↓
Return proposal
```

Success:

```text
Text/Image/PDF
        ↓
      /analyze
        ↓
Structured proposal
```

---

# 67. Phase 9 — AI → Task

Implement:

```text
Analyze
 ↓
Proposal
 ↓
User confirmation
 ↓
POST /api/tasks
```

Do not automatically create tasks.

Success:

```text
AI suggestions can be converted into normal tasks.
```

---

# 68. Phase 10 — Reminders

```text
□ Reminder model
□ Reminder schema
□ Reminder API
□ Reminder validation
□ Relative reminder calculation
□ Disable reminders for completed tasks
□ Disable reminders for deleted tasks
□ Reminder tests
```

Success:

```text
Tasks can have multiple valid reminders.
```

---

# 69. Phase 11 — Backend Final Testing

Test complete workflow:

```text
Text
 ↓
Analyze
 ↓
AI result
 ↓
Confirm
 ↓
Task
 ↓
Reminder
 ↓
Complete
 ↓
Reminder disabled
```

Then:

```text
Image
 ↓
OCR
 ↓
AI
 ↓
Task
```

Then:

```text
PDF
 ↓
PyMuPDF
 ↓
AI
 ↓
Task
```

---

# 70. FINAL BACKEND FLOW

The completed backend should follow:

```text
                         USER
                           │
                           ▼
                    React Frontend
                           │
                         HTTP
                           │
                           ▼
                    ┌─────────────┐
                    │   FastAPI   │
                    └──────┬──────┘
                           │
          ┌────────────────┼────────────────┐
          │                │                │
          ▼                ▼                ▼
       SQLite          Services          Files
                          │
              ┌───────────┼───────────┐
              │           │           │
              ▼           ▼           ▼
             AI          OCR         PDF
              │           │           │
              └───────────┼───────────┘
                          ▼
                    Structured Data
                          │
                     Validation
                          │
                          ▼
                     User Review
                          │
                          ▼
                        Task
                          │
                          ▼
                      Reminder
```

---

# 71. FINAL BACKEND API

Target API structure:

```text
/api

/tasks
/tasks/{id}
/tasks/{id}/complete

/sources
/sources/{id}

/analyze

/reminders
/reminders/{id}
```

---

# 72. BACKEND V1 DEFINITION OF DONE

The backend is complete when all of these work:

```text
□ FastAPI runs
□ SQLite works
□ SQLAlchemy works
□ Task CRUD works
□ Source CRUD works
□ Reminder CRUD works
□ Text processing works
□ PDF extraction works
□ Image OCR works
□ AI analysis works
□ AI output is validated
□ Deadline detection works
□ Action detection works
□ Priority detection works
□ Category detection works
□ Multiple proposed tasks work
□ AI does not automatically create tasks
□ User confirmation flow works through API
□ Reminder calculations work
□ Completed tasks disable reminders
□ File validation works
□ Errors are handled
□ API documentation works
□ Tests pass
□ No secrets are committed
```

---

# 73. FUTURE COMPATIBILITY

The backend should be designed so that future applications can consume the same API:

```text
                 FastAPI
                    │
        ┌───────────┼───────────┐
        ▼           ▼           ▼
      React       Android     Desktop
       Web         App         App
```

Do not make the backend dependent on React.

The backend must expose clean REST APIs.

---

# 74. FUTURE ANDROID REMINDERS

The future Android application should eventually handle actual local notifications.

Architecture:

```text
FastAPI
   ↓
Task synchronization
   ↓
Android local database
   ↓
Android notification/alarm API
   ↓
Notification
```

The backend should store reminder information but should not require a continuously running server to trigger a local Android reminder.

---

# 75. AI IDE INSTRUCTIONS

The AI coding IDE must follow these rules:

```text
You are implementing the backend according to this specification.

Before making changes:

1. Inspect the existing project.
2. Understand the current architecture.
3. Identify required files.
4. Explain the implementation plan briefly.

Then implement only the requested phase.

Do not:
- implement future phases
- rewrite unrelated code
- introduce unnecessary dependencies
- change the architecture without approval
- add cloud infrastructure
- add authentication unless requested
- expose API keys
- skip validation
- silently invent deadlines
- allow raw AI output directly into the database

After implementation:

1. Run relevant tests.
2. Fix errors.
3. Verify existing functionality.
4. Show changed files.
5. Explain how to run the feature.
6. Explain how to test it manually.

Preserve all previously working functionality.
```

---

# 76. FIRST AI IDE TASK

The first coding request should ONLY be:

```text
Implement Phase 1 of the backend specification.

Do not implement the database, AI, OCR, PDF processing, reminders, or task APIs yet.

Only:

1. Create the backend structure.
2. Create a Python virtual environment if appropriate.
3. Install the required Phase 1 dependencies.
4. Create the FastAPI application.
5. Create app/main.py.
6. Create configuration handling.
7. Create .env.example.
8. Create .gitignore.
9. Create requirements.txt.
10. Add a simple health-check endpoint.
11. Configure Uvicorn.
12. Verify that /docs works.
13. Run the application and test the health endpoint.

Do not add unnecessary dependencies.

Do not create placeholder business logic.

Do not implement future phases.

After completion, report:
- files created
- dependencies installed
- commands to run the backend
- test result
- any problems encountered.
```

---

# 77. NEXT AI IDE TASK

After Phase 1 is confirmed working, use:

```text
Implement Phase 2 of the backend specification.

Do not implement task APIs, AI, OCR, PDF processing, reminders, or frontend functionality.

Implement only:

1. SQLite configuration.
2. SQLAlchemy setup.
3. Database session management.
4. Task model.
5. Source model.
6. Reminder model.
7. Relationships between models.
8. Database initialization.
9. Basic database tests.

Follow the existing architecture.

Do not rewrite working Phase 1 code unnecessarily.

Run all relevant tests after implementation.

Report:
- changed files
- database schema
- tests performed
- test results
- how to verify the database manually.
```

---

# 78. DEVELOPMENT RULE

Always follow:

```text
ONE PHASE
   ↓
IMPLEMENT
   ↓
TEST
   ↓
FIX
   ↓
VERIFY
   ↓
NEXT PHASE
```

Never:

```text
PRD
 ↓
"Build everything"
 ↓
5000 lines of untested code
 ↓
debugging nightmare
```

---

# 79. PROJECT SUCCESS CRITERIA

The backend should eventually make this possible:

```text
User uploads screenshot
        ↓
FastAPI receives it
        ↓
OCR extracts text
        ↓
AI understands content
        ↓
AI returns structured proposal
        ↓
Backend validates result
        ↓
Frontend displays proposal
        ↓
User confirms
        ↓
Task is created
        ↓
Reminder is created
        ↓
Android/web client later schedules notification
```

This is the core backend product.

---

# 80. PRINCIPLE

Keep V1:

**Simple → Local → Modular → Testable → Replaceable**

The architecture should be strong enough to grow into:

```text
Local Web App
      ↓
PWA
      ↓
Android App
      ↓
Cloud Sync
      ↓
Multi-device AI Productivity Platform
```

without requiring a complete rewrite.
