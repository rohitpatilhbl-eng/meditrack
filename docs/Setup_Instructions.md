# MediTrack - Setup Instructions

## 1. Prerequisites

- Java JDK 25 (or JDK 17+)
- IntelliJ IDEA
- Git installed
- Maven (if not bundled with IntelliJ)

---

## 2. Clone the Repository (If using GitHub)

```bash
git clone <your-github-repository-link>
cd meditrack
```

If running locally, simply open the existing project folder.

---

## 3. Open in IntelliJ IDEA

1. Open IntelliJ IDEA
2. Click **Open**
3. Select the `meditrack` folder
4. Wait for Maven to auto-sync (if prompted)

---

## 4. Configure JDK

1. Go to **File → Project Structure**
2. Set **Project SDK** to JDK 25
3. Click **Apply** → **OK**

---

## 5. Build the Project

From the top menu:

Build → Rebuild Project

Ensure build completes successfully.

---

## 6. Run the Application

Navigate to:

```
src/main/java/com/airtribe/meditrack/Main.java
```

Right-click → **Run Main**

---

## 7. Load CSV Data (Optional)

To load previously saved patient data:

Run the program with argument:

```
--loadData
```

---

## 8. Exit Behavior

On selecting option `0` (Exit):

- Patient data is automatically saved to CSV
- Application terminates safely

---
