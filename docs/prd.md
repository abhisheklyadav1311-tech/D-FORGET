# D!FORGET

## Master Product Requirements Document — Android-First

**Version:** 2.0
**Platform Priority:** Android-first
**Project Type:** Student / Portfolio Project
**Architecture:** Android Client + Python FastAPI Backend
**Primary Goal:** Convert unstructured information into actionable tasks, deadlines, summaries, priorities, and reliable local reminders.

---

# 1. Product Overview

AI Task Organizer is an **AI-powered personal productivity application** that converts information from different sources into organized tasks and reminders.

Users frequently receive important information through:

* WhatsApp messages
* College notices
* PDFs
* Screenshots
* Images
* Emails
* Websites
* Class announcements
* Copied text
* Assignment instructions
* Event notices

The information is often unstructured.

For example:

> "All students are required to submit the DBMS assignment by Friday, 20 September. Upload the PDF to the portal. Late submissions will not be accepted."

The application should understand this information and produce:

**Title:** DBMS Assignment
**Description:** Submit the DBMS assignment as a PDF through the college portal.
**Deadline:** 20 September
**Priority:** High
**Subject:** DBMS
**Action Required:** Yes
**Suggested Reminder:** 19 September, 8:00 PM
**Summary:** Submit DBMS assignment PDF before the deadline.

The user then reviews the AI result and confirms what should become a permanent task.

---

# 2. Core Product Concept

The central concept is:

> **Capture → Understand → Extract → Summarize → Review → Confirm → Task → Reminder → Complete**

The AI does not blindly create tasks.

Instead:

```text
User provides information
        ↓
Android App
        ↓
FastAPI Backend
        ↓
Text / PDF / OCR processing
        ↓
AI analysis
        ↓
Structured task proposal
        ↓
Android App
        ↓
User reviews
        ↓
User confirms
        ↓
Task stored locally
        ↓
Reminder scheduled locally
        ↓
Android notification
        ↓
User completes task
```

---

# 3. Primary Goals

## 3.1 Main Goals

The application must:

1. Accept text, images, screenshots and PDFs.
2. Extract useful information from them.
3. Use AI to understand the content.
4. Detect whether an action is required.
5. Extract deadlines when present.
6. Generate concise summaries.
7. Identify priority.
8. Identify subject/category.
9. Generate one or multiple task proposals.
10. Allow the user to review AI suggestions.
11. Allow the user to edit AI suggestions.
12. Allow the user to confirm or reject suggestions.
13. Store confirmed tasks locally.
14. Create reliable local reminders.
15. Show Android notifications.
16. Allow users to mark tasks complete.
17. Preserve the original source information.
18. Work offline for existing tasks and reminders.
19. Avoid inventing deadlines or facts.
20. Keep the architecture simple enough for a student project.

---

# 4. Non-Goals for MVP

The first version will NOT attempt to build:

* Social networking
* Team collaboration
* Complex project management
* Calendar replacement
* Full email client
* WhatsApp integration through private APIs
* Cloud synchronization as a mandatory feature
* Multi-user collaboration
* Microservices architecture
* Kubernetes
* Redis
* Complex distributed systems
* Large-scale enterprise infrastructure
* Custom AI model training

These may be considered later.

---

# 5. Target Platform

## Primary Client

**Android**

Technology:

* Kotlin
* Jetpack Compose
* Android Studio
* Room
* WorkManager
* AlarmManager where appropriate
* Android Notifications
* Android Storage Access Framework / system file picker

## Backend

* Python
* FastAPI
* Pydantic
* SQLAlchemy
* SQLite initially
* PyMuPDF
* Tesseract OCR
* AI API

---

# 6. Architecture

## 6.1 High-Level Architecture

```text
                    USER
                      │
                      ▼
              ┌───────────────┐
              │ Android App   │
              │ Kotlin        │
              │ Jetpack       │
              │ Compose       │
              └───────┬───────┘
                      │
          ┌───────────┴───────────┐
          │                       │
          ▼                       ▼
   Local Task Data         FastAPI Backend
      Room DB                     │
          │                       │
          │              ┌────────┼────────┐
          │              │        │        │
          │              ▼        ▼        ▼
          │            PDF       OCR      AI
          │          Service    Service  Service
          │              │        │        │
          │              └────────┼────────┘
          │                       │
          │                       ▼
          │              Structured Result
          │                       │
          └───────────────◄───────┘
                      │
                      ▼
              User Confirmation
                      │
                      ▼
                 Room Database
                      │
                      ▼
              Android Scheduler
                │           │
          WorkManager   AlarmManager
                │           │
                └─────┬─────┘
                      ▼
              Android Notification
```

---

# 7. Responsibility Separation

This is a critical architectural rule.

## Android App owns:

* UI
* Local tasks
* Local source metadata
* Local reminder data
* Task completion
* Reminder scheduling
* Notifications
* Offline task access
* File selection
* Share-to-app entry point
* User confirmation

## Backend owns:

* AI processing
* OCR
* PDF text extraction
* AI structured analysis
* Input validation
* AI output validation
* Optional source processing
* Optional cloud synchronization later

## Backend MUST NOT be responsible for:

* Showing Android notifications
* Depending on an internet connection for reminders
* Keeping the app alive to fire reminders
* Replacing Android's notification system

### Core rule

> **The backend analyzes information. The Android device schedules and delivers reminders.**

---

# 8. User Input Methods

The application should support multiple input methods.

## 8.1 Paste Text

User can paste:

* Notices
* Messages
* Assignment descriptions
* Instructions
* Emails
* Announcements

Example:

```text
Paste information here...
```

Button:

**Analyze**

---

# 8.2 Image

User can select an image from the device.

Supported examples:

* Screenshot
* Notice photograph
* Assignment image
* Whiteboard photograph
* Document photograph

Flow:

```text
Select Image
     ↓
Upload
     ↓
OCR
     ↓
Extract Text
     ↓
AI Analysis
```

---

# 8.3 PDF

User selects a PDF through Android's system file picker.

Flow:

```text
Select PDF
    ↓
Backend receives PDF
    ↓
PyMuPDF extracts text
    ↓
AI analyzes text
```

If the PDF contains images instead of selectable text:

```text
PDF
 ↓
Text extraction fails / insufficient text
 ↓
OCR fallback
 ↓
AI analysis
```

---

# 8.4 Screenshot

Screenshots should be treated as images.

Example:

```text
Screenshot
    ↓
OCR
    ↓
Extracted text
    ↓
AI
    ↓
Task proposal
```

---

# 8.5 Android Share-to-App

Later in MVP/early V1, the application should support Android's share mechanism.

Example:

```text
WhatsApp / Chrome / Gallery / Files
              ↓
             Share
              ↓
       AI Task Organizer
              ↓
           Analyze
```

This should allow users to send supported content directly into the application.

The application should not require private APIs from other apps.

---

# 9. AI Inbox

The **AI Inbox** is the central feature.

It is the place where users send unorganized information.

Example:

```text
┌──────────────────────────────┐
│ AI Inbox                     │
├──────────────────────────────┤
│                              │
│ Paste text                   │
│ Upload image                 │
│ Upload PDF                   │
│                              │
│         [ Analyze ]          │
│                              │
└──────────────────────────────┘
```

After analysis:

```text
AI found:

1 task
1 deadline
1 action
Priority: High

[Review]
```

---

# 10. AI Analysis Requirements

The AI should identify:

### Required fields

* Title
* Description
* Deadline
* Priority
* Category
* Subject
* Action required
* Summary
* Confidence
* Source reference

### Optional fields

* Suggested reminder time
* Location
* Submission method
* Required materials
* Important instructions
* Multiple deadlines
* Multiple tasks

---

# 11. AI Output Rules

AI output must be structured.

Example conceptual structure:

```json
{
  "summary": "...",
  "action_required": true,
  "tasks": [
    {
      "title": "...",
      "description": "...",
      "deadline": "...",
      "priority": "high",
      "category": "...",
      "subject": "...",
      "confidence": "high"
    }
  ]
}
```

The actual backend schema should be implemented using Pydantic.

---

# 12. AI Safety / Accuracy Rules

## Rule 1 — Never invent deadlines

If the source says:

> "Submit soon"

AI must NOT turn this into:

> "Submit tomorrow at 8 PM."

Instead:

```text
deadline: null
confidence: low
```

---

## Rule 2 — Preserve ambiguity

If the source says:

> "Submit on Friday"

but the exact date cannot safely be determined:

The AI should flag the deadline as ambiguous rather than inventing a date.

---

## Rule 3 — AI suggestions require confirmation

AI should propose tasks.

It should not automatically create permanent tasks.

```text
Source
 ↓
AI Proposal
 ↓
User Review
 ↓
Confirm
 ↓
Permanent Task
```

---

## Rule 4 — One source may create multiple tasks

Example:

> "Submit assignment by Monday and attend presentation on Wednesday."

Output:

```text
Task 1:
Submit assignment
Deadline: Monday

Task 2:
Attend presentation
Deadline: Wednesday
```

---

## Rule 5 — Information-only notices

Not every notice is a task.

Example:

> "College will remain closed on Monday."

AI should identify:

```text
Action Required: No
```

The user may still choose to save it as information.

---

# 13. Task Proposal Screen

After AI analysis, show a review screen.

Example:

```text
AI ANALYSIS

Summary
Submit the DBMS assignment through the portal
before the specified deadline.

────────────────────

TASK

Title
DBMS Assignment

Description
Complete and upload the DBMS assignment.

Deadline
20 September

Priority
High

Subject
DBMS

Action Required
Yes

────────────────────

Reminder
19 September
8:00 PM

[ Edit ]

[ Reject ]

[ Add Task ]
```

The user must be able to modify AI-generated values.

---

# 14. Task Model

Each task should contain:

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

Potential status values:

```text
pending
completed
cancelled
```

Priority:

```text
low
medium
high
urgent
```

---

# 15. Task Creation

Tasks can be created through:

### Manual creation

User directly creates a task.

### AI creation

AI generates proposal → user confirms → task created.

Manual tasks and AI-generated tasks should use the same underlying Task model.

---

# 16. Task Editing

User must be able to edit:

* Title
* Description
* Deadline
* Priority
* Category
* Subject
* Status

AI-generated tasks should not become immutable.

---

# 17. Task Completion

User can mark a task complete.

Example:

```text
○ Submit DBMS assignment
```

After completion:

```text
✓ Submit DBMS assignment
```

Completion should store:

```text
status = completed
completed_at = timestamp
```

---

# 18. Dashboard

The main dashboard should provide a quick overview.

Recommended sections:

## Today

Tasks requiring attention today.

## Upcoming

Future tasks sorted chronologically.

## Inbox

Unreviewed AI analysis/source items.

## Completed

Completed tasks.

Example:

```text
TODAY

2 Tasks

┌────────────────────────────┐
│ DBMS Assignment            │
│ Due today                  │
│ HIGH                       │
└────────────────────────────┘

┌────────────────────────────┐
│ Prepare DSA Presentation   │
│ Due 8 PM                   │
│ MEDIUM                     │
└────────────────────────────┘
```

---

# 19. Navigation

Recommended Android navigation:

```text
Home
Tasks
AI Inbox
Completed
Settings
```

Optional later:

```text
Calendar
Search
Sources
Statistics
```

Keep the first version simple.

---

# 20. Reminders

Reminders are a core feature.

The application should allow:

* One or more reminders per task
* Custom reminder date
* Custom reminder time
* Enable/disable reminder
* Edit reminder
* Delete reminder

Example:

```text
Task:
DBMS Assignment

Deadline:
20 September

Reminders:

19 September — 8:00 PM
20 September — 8:00 AM
```

---

# 21. Reminder Architecture

Reminder data is stored locally.

```text
Task
 ↓
Reminder
 ↓
Room Database
 ↓
Android Scheduler
 ↓
Notification
```

The application should use:

### WorkManager

For work that does not require exact timing.

### AlarmManager

For reminders where exact timing is required and appropriate under Android's current platform rules.

The implementation must account for Android's battery and exact-alarm restrictions.

---

# 22. Notifications

Notifications should contain:

```text
DBMS Assignment

Due tomorrow.

[Open Task]
```

Optional actions:

```text
[Complete]
[Snooze]
[Open]
```

Notification behavior should be designed so that reminders remain useful even if:

* App UI is closed
* App is not currently open
* Device is offline

Existing locally scheduled reminders must not depend on the backend.

---

# 23. Notification Permission

On Android versions requiring notification permission:

Do not immediately request permission on first launch.

Instead:

```text
User creates/enables reminder
        ↓
Explain notifications
        ↓
Request permission
```

If permission is denied:

```text
Notifications are disabled.

Open Settings
```

The app should clearly communicate the consequence.

---

# 24. Offline Functionality

The following should work offline:

* Open existing tasks
* View dashboard
* Edit tasks
* Complete tasks
* Create manual tasks
* View reminders
* Schedule local reminders
* Receive scheduled local notifications

The following may require internet connectivity in the initial version:

* AI analysis
* Backend OCR
* Backend PDF processing

Later, local AI can reduce this dependency.

---

# 25. Local Database

Android should use:

**Room**

for local application data.

Likely entities:

```text
Task
Reminder
Source
```

Potential future entities:

```text
AIAnalysis
Category
Settings
SyncState
```

---

# 26. Source Model

A Source represents the original information from which a task was generated.

Fields:

```text
id
type
filename
original_text
summary
created_at
```

Source types:

```text
text
image
screenshot
pdf
```

A Task may reference its source.

This allows the user to understand:

> "Where did this task come from?"

---

# 27. Source Detail

The user should eventually be able to open a source and see:

```text
SOURCE

Type:
PDF

Summary:
DBMS assignment instructions.

Created:
10 September

Generated Tasks:
• Complete DBMS assignment
• Upload assignment to portal

Original Content:
...
```

This provides transparency for AI-generated tasks.

---

# 28. PDF Processing

Backend should use **PyMuPDF**.

Flow:

```text
Android
 ↓
PDF upload
 ↓
FastAPI
 ↓
PyMuPDF
 ↓
Extract text
 ↓
Clean text
 ↓
AI
```

Requirements:

* Validate file type
* Validate file size
* Reject unsupported files
* Handle empty PDFs
* Handle corrupted PDFs
* Handle image-only PDFs
* Avoid executing uploaded files

---

# 29. OCR

Initial OCR solution:

**Tesseract / pytesseract**

Flow:

```text
Image
 ↓
OCR
 ↓
Extracted text
 ↓
Text cleaning
 ↓
AI
```

OCR should handle:

* Screenshots
* Printed notices
* Photographed documents

OCR errors should not silently become facts.

The AI should be told that extracted text may contain OCR errors.

---

# 30. Text Cleaning

Before sending text to AI:

```text
Raw input
 ↓
Normalize whitespace
 ↓
Remove unnecessary noise
 ↓
Preserve dates
 ↓
Preserve important formatting
 ↓
Limit excessive content
 ↓
AI
```

Do not aggressively clean information that could affect meaning.

---

# 31. Backend API

Initial API structure:

## Tasks

```http
GET /api/tasks
GET /api/tasks/{id}
POST /api/tasks
PUT /api/tasks/{id}
DELETE /api/tasks/{id}
PATCH /api/tasks/{id}/complete
```

## Sources

```http
POST /api/sources
GET /api/sources
GET /api/sources/{id}
DELETE /api/sources/{id}
```

## AI

```http
POST /api/analyze
```

## Reminders

Backend reminder APIs may exist for future synchronization:

```http
POST /api/reminders
GET /api/reminders
PUT /api/reminders/{id}
DELETE /api/reminders/{id}
```

However, **the Android local reminder system remains the actual notification mechanism for MVP.**

---

# 32. Analyze API

The central backend endpoint:

```http
POST /api/analyze
```

Possible input:

```text
text
```

or:

```text
image
```

or:

```text
pdf
```

The backend determines the processing pipeline.

```text
TEXT
 ↓
Clean
 ↓
AI

IMAGE
 ↓
OCR
 ↓
Clean
 ↓
AI

PDF
 ↓
PyMuPDF
 ↓
Clean
 ↓
AI
```

Response:

```text
summary
action_required
tasks[]
confidence
source information
```

The endpoint should return a **proposal**, not automatically create permanent tasks.

---

# 33. AI Service Architecture

Do not tightly couple the application to one AI provider.

Create an abstraction such as:

```text
AI Service
   │
   ├── Provider implementation
   │
   └── Structured output validation
```

This allows the AI provider to be changed later.

Possible future providers:

* Cloud AI
* Local model
* Different commercial API

---

# 34. AI Cost Strategy

Because this is a student project:

### Initial approach

Use an external AI API only for development/testing.

Keep API usage limited.

Avoid:

* sending unnecessary repeated requests
* sending huge documents without processing
* analyzing the same source repeatedly

### Future

A local model can be introduced later if hardware and model quality are sufficient.

---

# 35. Security

## File security

* Validate file type
* Validate file size
* Sanitize filenames
* Never execute uploaded files
* Store uploads safely
* Remove temporary files when no longer required

## API security

* API keys must remain on backend
* Never expose AI API keys in Android APK
* Use environment variables
* Validate all incoming data
* Validate AI output
* Handle malformed requests safely

## Git security

Never commit:

```text
.env
API keys
secrets
private credentials
large upload files
```

---

# 36. Error Handling

The application must handle:

## Empty input

```text
Please enter or upload something to analyze.
```

## Unsupported file

```text
This file type is not supported.
```

## OCR failure

```text
We couldn't read useful text from this image.
```

## PDF failure

```text
We couldn't extract readable content from this PDF.
```

## AI failure

```text
Analysis failed. Please try again.
```

## No action detected

```text
No clear action was found in this information.
```

## Ambiguous deadline

```text
A possible deadline was found, but the date is unclear.
```

---

# 37. Loading States

AI processing should provide meaningful progress states.

Example:

```text
Uploading...
      ↓
Reading content...
      ↓
Extracting text...
      ↓
Analyzing...
      ↓
Finding important information...
      ↓
Preparing tasks...
      ↓
Ready
```

Not every state needs to be shown for every input type.

---

# 38. UX Principle

The application should minimize the number of decisions the user needs to make.

Bad flow:

```text
Upload
→ configure 10 options
→ select category
→ select subject
→ enter deadline
→ select priority
→ analyze
```

Better:

```text
Upload
 ↓
AI analyzes
 ↓
Review
 ↓
Confirm
```

The AI should do the initial organization.

---

# 39. Manual Task Creation

Users should not need AI to create ordinary tasks.

Example:

```text
+ Add Task

Title
Description
Deadline
Priority
Category
Subject
Reminder

[Save]
```

This should work completely offline.

---

# 40. Search

Search can be added after the basic task system works.

Search should support:

* Task title
* Description
* Subject
* Category

Example:

```text
Search: DBMS
```

Results:

```text
DBMS Assignment
DBMS Viva Preparation
DBMS Project
```

---

# 41. Categories

Initial categories may include:

* Assignment
* Exam
* Project
* Class
* College
* Personal
* Event
* Other

Users should eventually be able to create custom categories.

---

# 42. Subjects

Subjects should be free-form.

Examples:

```text
DSA
DBMS
Operating Systems
Computer Networks
Mathematics
```

AI may suggest a subject, but the user can edit it.

---

# 43. Priority Detection

AI may infer priority from language.

Examples:

### High

```text
Mandatory
Urgent
Last date
No late submission
Required
```

### Medium

```text
Recommended
Should complete
Important
```

### Low

```text
Optional
If possible
```

The user must always be able to override the priority.

---

# 44. Deadline Detection

The system should recognize:

* Exact dates
* Relative dates
* Date + time
* Day names
* Submission windows

Examples:

```text
20 September
Friday
Tomorrow
Next Monday
20 September at 5 PM
Before 10 AM
```

If the date cannot be safely resolved, the system must flag ambiguity.

---

# 45. Reminder Suggestions

AI may suggest a reminder based on the deadline.

Example:

```text
Deadline:
20 September, 5 PM

Suggested reminder:
19 September, 8 PM
```

But this is only a suggestion.

User can:

* Accept
* Change
* Remove

---

# 46. Multiple Reminders

A task may have multiple reminders.

Example:

```text
Assignment

Deadline:
20 September, 5 PM

Reminders:
19 Sep — 8 PM
20 Sep — 9 AM
20 Sep — 3 PM
```

---

# 47. Calendar

Calendar functionality should NOT be required for the first MVP.

Later it can provide:

```text
September

20
DBMS Assignment

22
DSA Presentation

25
OS Test
```

Calendar should consume the same Task/Deadline data rather than introducing another task system.

---

# 48. Settings

Initial settings:

```text
Notifications
Default reminder time
Theme
AI settings
Storage
About
```

Potential future settings:

```text
Default priority
Default category
AI provider
Privacy controls
Cloud sync
```

---

# 49. Privacy Model

The application should make it clear when information leaves the device.

For cloud AI analysis:

```text
Your content
 ↓
Backend
 ↓
AI provider
```

Users should eventually be informed that uploaded content may be processed by the configured AI service.

For local tasks:

```text
Task
 ↓
Android Room database
```

No internet is required for normal task usage.

---

# 50. Data Lifecycle

Example:

```text
User uploads screenshot
        ↓
Temporary processing
        ↓
OCR
        ↓
AI analysis
        ↓
Proposal returned
        ↓
User confirms
        ↓
Task saved
        ↓
Source optionally saved
        ↓
Reminder scheduled
```

Temporary processing files should not remain unnecessarily.

---

# 51. Android App Screens

Initial screens:

### 1. Home

Shows:

* Today's tasks
* Upcoming tasks
* Quick add
* AI Inbox entry

### 2. AI Inbox

Shows:

* Paste text
* Image
* PDF
* Shared content
* Previous analyses

### 3. Analysis Result

Shows:

* Summary
* Proposed tasks
* Deadlines
* Priority
* Subject
* Reminder suggestions

### 4. Task Detail

Shows:

* Title
* Description
* Deadline
* Priority
* Category
* Subject
* Reminders
* Source

### 5. Tasks

Shows all active tasks.

### 6. Completed

Shows completed tasks.

### 7. Settings

Shows application configuration.

---

# 52. Android UI Technology

Use:

**Jetpack Compose**

Advantages:

* Native Android
* Modern UI
* Kotlin integration
* Less XML
* Good maintainability
* Suitable for this project

Avoid introducing unnecessary UI frameworks.

---

# 53. Android Architecture

Use a simple architecture such as:

```text
UI
 ↓
ViewModel
 ↓
Repository
 ↓
Room
```

For backend operations:

```text
UI
 ↓
ViewModel
 ↓
Repository
 ↓
Network/API
 ↓
FastAPI
```

Do not introduce unnecessary architecture complexity.

---

# 54. Local Data Flow

```text
Compose UI
    ↓
ViewModel
    ↓
Repository
    ↓
Room DAO
    ↓
SQLite
```

---

# 55. Backend Data Flow

```text
Android
   ↓
HTTP
   ↓
FastAPI Route
   ↓
Validation
   ↓
Service
   ↓
PDF/OCR/AI
   ↓
Pydantic response
   ↓
Android
```

---

# 56. Development Strategy

Development should happen incrementally.

Do NOT build the entire application at once.

Recommended order:

```text
Phase 1
Backend foundation

Phase 2
Backend database

Phase 3
Task APIs

Phase 4
Source/file handling

Phase 5
PDF extraction

Phase 6
OCR

Phase 7
AI service

Phase 8
Unified AI analysis

Phase 9
Android project

Phase 10
Android local database

Phase 11
Android task UI

Phase 12
Backend integration

Phase 13
AI Inbox

Phase 14
Local reminders

Phase 15
Notifications

Phase 16
Share-to-app

Phase 17
Testing

Phase 18
APK release
```

---

# 57. Backend Project Structure

Recommended:

```text
backend/
│
├── app/
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
├── uploads/
├── .env
├── .gitignore
├── requirements.txt
└── README.md
```

---

# 58. Android Project Structure

Recommended conceptual structure:

```text
android/
│
├── app/
│
└── src/main/java/
    └── com.example.aitaskorganizer/
        │
        ├── data/
        │   ├── local/
        │   │   ├── database/
        │   │   ├── dao/
        │   │   └── entities/
        │   │
        │   ├── remote/
        │   │   ├── api/
        │   │   └── dto/
        │   │
        │   └── repository/
        │
        ├── ui/
        │   ├── home/
        │   ├── tasks/
        │   ├── inbox/
        │   ├── analysis/
        │   ├── completed/
        │   └── settings/
        │
        ├── notifications/
        │
        ├── reminders/
        │
        └── MainActivity.kt
```

The exact package structure can be adjusted during implementation.

---

# 59. Backend Technology Stack

| Component       | Technology                 |
| --------------- | -------------------------- |
| Language        | Python                     |
| API             | FastAPI                    |
| Server          | Uvicorn                    |
| Validation      | Pydantic                   |
| ORM             | SQLAlchemy                 |
| Database        | SQLite                     |
| PDF             | PyMuPDF                    |
| OCR             | Tesseract / pytesseract    |
| AI              | External AI API initially  |
| Configuration   | `.env` / pydantic-settings |
| HTTP            | httpx                      |
| Testing         | pytest                     |
| Version control | Git/GitHub                 |

---

# 60. Android Technology Stack

| Component       | Technology                     |
| --------------- | ------------------------------ |
| Language        | Kotlin                         |
| UI              | Jetpack Compose                |
| IDE             | Android Studio                 |
| Local database  | Room                           |
| Background work | WorkManager                    |
| Exact reminders | AlarmManager where appropriate |
| Notifications   | Android Notification APIs      |
| Networking      | Retrofit/OkHttp or equivalent  |
| File selection  | Android system file picker     |
| Architecture    | ViewModel + Repository         |
| Distribution    | APK initially                  |

Keep dependencies minimal.

---

# 61. MVP Definition

The MVP is complete when a user can:

```text
1. Open Android app
2. Create a task manually
3. View the task
4. Edit the task
5. Complete the task
6. Set a reminder
7. Receive a local notification
8. Paste text
9. Send text to backend
10. Receive AI analysis
11. Review proposed task
12. Edit proposal
13. Confirm proposal
14. Save it as a task
15. Upload an image
16. OCR the image
17. Analyze OCR text
18. Upload a PDF
19. Extract PDF text
20. Analyze PDF
21. Use the app offline for existing tasks/reminders
```

---

# 62. MVP Success Criteria

The project should demonstrate:

### Functional

* Tasks work reliably.
* AI analysis works.
* OCR works.
* PDF extraction works.
* Reminders work.
* Notifications work.
* Offline task access works.

### Technical

* Clean Android architecture.
* Clean FastAPI architecture.
* Structured AI output.
* Input validation.
* Error handling.
* No exposed API keys.
* No unnecessary services.

### UX

A user should be able to go from:

```text
Unstructured notice
       ↓
AI analysis
       ↓
Confirmed task
       ↓
Reminder
```

with minimal effort.

---

# 63. Testing Strategy

## Backend

Test:

* API endpoints
* Pydantic validation
* Database operations
* PDF extraction
* OCR handling
* AI response validation
* Error cases

Use:

```text
pytest
```

## Android

Test:

* Task creation
* Task editing
* Completion
* Room database
* Reminder scheduling
* Notification behavior
* API integration
* Loading states
* Error states

---

# 64. Important Edge Cases

The system must handle:

### No deadline

```text
Task:
Read DBMS chapter

Deadline:
None
```

### Multiple deadlines

```text
Draft due Monday
Final submission due Friday
```

These should not be merged incorrectly.

### Multiple tasks

One source can produce several tasks.

### Conflicting information

The system should flag uncertainty rather than silently choose an arbitrary value.

### OCR mistakes

Dates and numbers should be handled cautiously.

### Duplicate input

The system should eventually detect possible duplicate tasks.

### Offline state

The app should still display locally stored information.

### Notification permission denied

The app must gracefully explain that reminders may not appear.

---

# 65. Duplicate Detection

Future enhancement.

Example:

User already has:

```text
Submit DBMS Assignment
```

Then they upload the same notice again.

AI/system could detect:

```text
Possible duplicate task found.
```

Options:

```text
Keep existing
Create anyway
Review
```

This should not be required for the first MVP.

---

# 66. Future Cloud Sync

Cloud synchronization can be added later.

Architecture:

```text
Android Room
     ↕
Sync API
     ↕
Cloud Database
```

Potential future database:

**PostgreSQL**

But SQLite remains sufficient for the initial project.

---

# 67. Multi-Device Future

Later:

```text
Android
    ↕
Cloud
 ↙     ↘
Desktop  Web
```

The backend should therefore use clean APIs even though Android is the first client.

---

# 68. Desktop Future

Desktop is not the primary MVP platform.

It can later become another client:

```text
FastAPI
   ↕
Android
   ↕
Desktop
```

The desktop application would have its own OS-specific notification system.

The backend should remain client-independent.

---

# 69. Future Local AI

Current:

```text
Android
 ↓
Backend
 ↓
Cloud AI
```

Potential future:

```text
Android
 ↓
Local AI
 ↓
Analysis
```

or:

```text
Android
 ↓
Local AI when possible
 ↓
Backend AI fallback
```

This can improve:

* Privacy
* Offline operation
* Cost

But it is not required for MVP.

---

# 70. Future Features

Possible future versions:

* Calendar
* Recurring tasks
* Advanced search
* Natural-language task creation
* Voice input
* Voice-to-task
* Email integration
* Browser extension
* Desktop application
* Cloud synchronization
* Local AI
* Duplicate detection
* Smart scheduling
* Analytics
* Habit tracking
* Widgets
* Lock-screen reminders
* Wear OS support

These should not complicate the MVP.

---

# 71. Project Principles

The entire project should follow these principles:

### 1. Simplicity

Prefer simple solutions over complicated infrastructure.

### 2. Local-first for productivity data

Tasks and reminders should remain usable without internet.

### 3. AI-assisted, not AI-controlled

AI proposes.

User confirms.

### 4. No invented information

Uncertainty must be preserved.

### 5. Android owns reminders

The phone schedules and delivers local notifications.

### 6. Backend owns processing

FastAPI handles AI, OCR and PDF processing.

### 7. Structured data

AI output must be validated before entering the application.

### 8. Incremental development

Build one feature at a time.

### 9. Minimal dependencies

Do not add libraries without a reason.

### 10. Future-proof APIs

The backend should be usable by Android now and desktop/web clients later.

---

# 72. Final System Flow

The intended complete user experience is:

```text
                 USER
                   │
                   ▼
        ┌─────────────────────┐
        │ Capture Information │
        │                     │
        │ Text / Image / PDF  │
        └──────────┬──────────┘
                   │
                   ▼
             Android App
                   │
                   ▼
             FastAPI Backend
                   │
          ┌────────┼────────┐
          ▼        ▼        ▼
         PDF      OCR       AI
          │        │        │
          └────────┼────────┘
                   ▼
             AI Analysis
                   │
                   ▼
          Structured Proposal
                   │
                   ▼
             Android App
                   │
                   ▼
             User Reviews
                   │
          ┌────────┴────────┐
          │                 │
        Reject            Confirm
                            │
                            ▼
                       Task Created
                            │
                            ▼
                       Room Database
                            │
                            ▼
                     Reminder Created
                            │
                            ▼
                  Android Scheduler
                            │
                            ▼
                       Notification
                            │
                            ▼
                         User
                            │
                            ▼
                     Complete Task
```

---

# 73. Final Architecture Decision

## PRIMARY CLIENT

**Android**

```text
Kotlin
Jetpack Compose
Room
WorkManager
AlarmManager
Android Notifications
```

## BACKEND

**Python**

```text
FastAPI
SQLAlchemy
SQLite
Pydantic
```

## CONTENT PROCESSING

```text
PyMuPDF
Tesseract OCR
```

## AI

```text
External AI API initially
↓
Local AI possible later
```

## STORAGE RESPONSIBILITY

```text
Android:
Tasks
Reminders
Local user data

Backend:
AI processing
OCR
PDF processing
Optional server-side source/task data
```

## REMINDER RESPONSIBILITY

```text
ANDROID DEVICE
     ↓
Scheduler
     ↓
Notification
```

**Never make the user's reminder reliability depend on the backend being online.**

---

# 74. Development Rule for AI Coding Tools

When implementing this project with an AI coding assistant:

1. Inspect the existing project before changing anything.
2. Implement only the requested phase.
3. Do not implement future phases automatically.
4. Do not introduce unnecessary dependencies.
5. Do not replace working architecture without justification.
6. Explain important architectural decisions.
7. Run tests after implementation.
8. Fix errors before moving forward.
9. Preserve existing functionality.
10. Keep Android and backend responsibilities separate.
11. Do not move notification scheduling to the backend.
12. Do not expose AI API keys in the Android application.
13. Do not automatically create tasks from AI output without user confirmation.

---

# 75. Product Definition in One Sentence

> **d!forget is an Android-first productivity application that turns unstructured information such as notices, screenshots, PDFs and text into verified actionable tasks, while using the Android device itself to reliably store, schedule and deliver reminders.**
