### Project Overview 📌

**Project Name**: Purchease API

**Description**: A Spring Boot-based RESTful API backend project.

**Key Features**: User management, exception handling, integrated filtering/logging, and a standardized response structure.

---

### Project Structure 📂

```
📦 Project Root
├── api                  # API layer
│   ├── common           # Common utilities and error handling
│   │   ├── annotation   # Custom annotations
│   │   ├── api          # API response structure classes
│   │   ├── error        # Error codes and error interfaces
│   │   └── exception    # Custom exception classes
│   ├── filter           # Logging filters for request/response
│   └── interceptor      # Request interceptors for authorization
├── db                   # Database layer
│   ├── user             # User entity and repository
│   │   ├── enums        # User status enums
│   │   ├── UserEntity   # User entity class
│   │   └── UserRepository # Repository interface
│   └── BaseEntity       # Common base entity for inheritance
├── gradle/wrapper       # Gradle wrapper files
├── .gitignore           # Git ignore file
├── build.gradle         # Gradle build configuration
├── gradlew              # Gradle wrapper script (Linux/Mac)
├── gradlew.bat          # Gradle wrapper script (Windows)
└── settings.gradle      # Gradle settings
```

---

### Key Features 🔑

### 1. **API Response Integration**

A standardized response structure for consistency.

- **`Api<T>`**: Wraps API responses with success/error status.
- **`Result`**: Contains result codes, messages, and descriptions.

**Example**:

```java
public static <T> Api<T> OK(T data) {
    var api = new Api<T>();
    api.result = Result.OK();
    api.body = data;
    return api;
}
```

---

### 2. **Global Error Handling** 🚨

Centralized error management using enums and interfaces.

- **`ErrorCode`**: Global error codes (e.g., `BAD_REQUEST`, `SERVER_ERROR`).
- **`UserErrorCode`**: User-specific error codes.
- **`ApiException`**: Custom exception class for better error context.

**Example**:

```java
public class ApiException extends RuntimeException {
    private final ErrorCodeInterface errorCodeInterface;

    public ApiException(ErrorCodeInterface errorCodeInterface) {
        super(errorCodeInterface.getDescription());
        this.errorCodeInterface = errorCodeInterface;
    }
}
```

---

### 3. **Request/Response Logging Filter** 🛡

Integrated request/response filtering for improved debugging.

- **`LoggerFilter`**: Logs request/response headers and bodies.
- Caches content using `ContentCachingRequestWrapper` and `ContentCachingResponseWrapper`.

**Example Logs**:

```
>>>>> uri : /api/user, method : POST, header : [Content-Type: application/json], body : {"email":"test@example.com"}
<<<<< uri : /api/user, method : POST, header : [Status: 200], body : {"result":"success"}
```

---

### 4. **Authorization Interceptor** 🔐

Pre-authorization checks before request processing.

- Skips `OPTIONS` requests and static resource files.
- Intercepts and validates requests for business logic authorization.

**Example**:

```java
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    log.info("Authorization Interceptor uri: {}", request.getRequestURI());
    // TODO: Implement authorization logic
    return true;
}
```

---

### 5. **Custom Annotations** 🏷

Simplifies class categorization and enhances readability.

- **`@Business`**: Marks business service classes.
- **`@Converter`**: Marks converter service classes.

---

### Database Layer 🗄

- **BaseEntity**: Contains common fields (`id`, etc.).
- **UserEntity**: Manages user details, statuses, and timestamps.
- **UserRepository**: Provides methods for querying user data with custom filters.

**Custom Query Example**:

```java
Optional<UserEntity> findFirstByEmailAndPasswordAndStatusOrderByIdDesc(String email, String password, UserStatus status);
```

---

### Technologies Used 🛠

- **Backend**: Java 17, Spring Boot
- **Database**: JPA (with MySQL or other relational DBs)
- **Logging**: SLF4J, Spring Boot Filter
- **Build Tool**: Gradle
- **Dependencies**: Lombok, Spring Web, Spring Data JPA

---

### Key Takeaways 💡

- Centralized **error handling** using custom exceptions and enums.
- Detailed **request/response logging** for debugging and tracing.
- Flexible and extendable **API response structure**.
- Clear **authorization flow** using interceptors.
- Modular **code organization** with custom annotations and reusable components.

---

### Sample API Response 📄

```json
{
  "result": {
    "resultCode": 200,
    "resultMessage": "Success",
    "resultDescription": "User retrieved successfully"
  },
  "body": {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com",
    "status": "REGISTERED"
  }
}
```
