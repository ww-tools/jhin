# Junie Development Guidelines

This document contains comprehensive development guidelines derived from the junie-guidelines module to aid future development on this project. These guidelines cover modern development practices, design patterns, and best practices across multiple technologies.

## Table of Contents

1. [General Principles](#general-principles)
2. [Java Development](#java-development)
3. [Spring Boot Development](#spring-boot-development)
4. [TypeScript Development](#typescript-development)
5. [Angular Development](#angular-development)
6. [PrimeNG Development](#primeng-development)
7. [Tailwind CSS Development](#tailwind-css-development)
8. [Clean Code Principles](#clean-code-principles)
9. [SOLID Principles](#solid-principles)
10. [DRY Principles](#dry-principles)
11. [Design Patterns](#design-patterns)

## General Principles

### Code Quality Standards
- Prioritize maintainability, readability, and performance
- Use modern language features and frameworks
- Follow established naming conventions
- Write self-documenting code
- Implement comprehensive testing strategies
- Maintain consistent code organization

### Version Requirements
- **Java**: 25 LTS or later
- **TypeScript**: 5.9 or later
- **Angular**: v20+ with signals and standalone components
- **PrimeNG**: v20+ with Angular v20+ compatibility
- **Spring Boot**: Latest stable version
- **Tailwind CSS**: 4.1 with Oxide engine

## Java Development

### Modern Java Features
- Leverage virtual threads for high-throughput concurrent applications
- Use records for immutable data structures with validation
- Apply sealed interfaces and classes for controlled inheritance
- Utilize enhanced pattern matching with switch expressions
- Implement text blocks for multi-line strings

### Code Organization
- Follow package naming: `com.company.project.module`
- Keep classes focused on single responsibility
- Use meaningful, descriptive names
- Organize imports: static first, then alphabetically

### Best Practices
- Prefer composition over inheritance
- Use `Optional<T>` for potentially null return types
- Validate parameters with `Objects.requireNonNull()`
- Apply proper exception handling with custom exception classes
- Use try-with-resources for automatic resource management

### Concurrency
- Use high-level utilities from `java.util.concurrent`
- Prefer immutable objects in concurrent environments
- Apply virtual threads for scalable concurrent processing

### Example: Modern Java Service
```java
public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    
    public UserService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.emailService = Objects.requireNonNull(emailService);
    }
    
    // Using Virtual Threads for concurrent processing
    public void notifyActiveUsersAsync(String message) {
        var activeUsers = findActiveUsers();
        
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var tasks = activeUsers.stream()
                .map(user -> executor.submit(() -> {
                    emailService.sendEmail(user.getEmail(), message);
                    return user.getEmail();
                }))
                .toList();
        }
    }
}
```

## Spring Boot Development

### Core Guidelines

#### 1. Constructor Injection
- Declare mandatory dependencies as `final` fields
- Inject through constructor (Spring auto-detects single constructor)
- Avoid field/setter injection in production code

```java
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestClient restClient;

    public OrderService(OrderRepository orderRepository, 
                        RestClient.Builder builder) {
        this.orderRepository = orderRepository;
        this.restClient = builder
                .baseUrl("http://catalog-service.com")
                .requestInterceptor(new ClientCredentialTokenInterceptor())
                .build();
    }
}
```

#### 2. Package-Private Components
- Use default visibility for Controllers, `@Configuration` classes, and `@Bean` methods
- Reinforces encapsulation while allowing Spring's classpath scanning

#### 3. Configuration Properties
- Group application-specific properties with common prefix
- Use `@ConfigurationProperties` classes with validation annotations
- Prefer environment variables over profiles

```java
@ConfigurationProperties(prefix = "app.api")
public record ApiConfig(
    String baseUrl,
    int timeout,
    int retryAttempts
) {}
```

#### 4. Transaction Boundaries
- Define each Service method as a transactional unit
- Use `@Transactional(readOnly = true)` for query-only methods
- Use `@Transactional` for data-modifying methods

#### 5. Disable Open Session in View
- Set `spring.jpa.open-in-view=false` to avoid N+1 problems
- Forces explicit fetching of required associations

#### 6. Separate Web from Persistence
- Don't expose entities directly in controllers
- Define explicit request/response DTOs with validation
- Use bean mappers like MapStruct for conversions

#### 7. REST API Design
- Structure URLs as `/api/v{version}/resources`
- Use `ResponseEntity<T>` for explicit status codes
- Implement pagination for collections
- Use consistent JSON naming (camelCase or snake_case)

#### 8. Exception Handling
- Use `@ControllerAdvice` for global exception handling
- Return consistent error responses (consider RFC 9457 ProblemDetails)

#### 9. Logging
- Use SLF4J with proper logging framework
- Guard expensive log calls with level checks
- Protect sensitive data from logs

```java
if (logger.isDebugEnabled()) {
    logger.debug("Detailed state: {}", computeExpensiveDetails());
}
```

## TypeScript Development

### Configuration
- Always use strict mode with `"strict": true`
- Enable `"noUncheckedIndexedAccess": true`
- Use `"exactOptionalPropertyTypes": true`
- Set `"noImplicitReturns": true`

### Type Safety
- Prefer type inference when obvious from context
- Use explicit types for function parameters and return types
- Avoid `any`; use `unknown` when type is uncertain
- Use `readonly` for immutable data structures
- Prefer union types over enums

### Modern Patterns
```typescript
// Generic repository pattern
function createRepository<T extends { id: string }>(
  items: readonly T[]
): Repository<T> {
  return {
    findById: (id: string): T | undefined => 
      items.find(item => item.id === id),
    getAll: (): readonly T[] => items,
  };
}

// Proper error handling
class UserService {
  async fetchUser(id: string): Promise<User> {
    try {
      const response = await fetch(`/api/users/${id}`);
      if (!response.ok) {
        throw new Error(`Failed to fetch user: ${response.statusText}`);
      }
      return this.validateUser(await response.json());
    } catch (error) {
      console.error('Error fetching user:', error);
      throw error;
    }
  }
}
```

### Best Practices
- Use arrow functions for callbacks and short functions
- Prefer function declarations for named module-level functions
- Always specify return types for public APIs
- Use custom error classes that extend `Error`
- Prefer `async/await` over Promise chains

## Angular Development

### Modern Angular (v20+)
- **Persona**: Expert in Angular v20+ with signals, standalone components, and new control flow
- Use signals for reactive state management
- Embrace standalone components (don't set `standalone: true` explicitly)
- Utilize new control flow (`@if`, `@for`, `@switch`)

### Component Best Practices
- Always use standalone components over NgModules
- Use signals for state management with `signal()`, `computed()`
- Use `input()` signal instead of `@Input()` decorator
- Use `output()` function instead of `@Output()` decorator
- Set `changeDetection: ChangeDetectionStrategy.OnPush`

### Example Modern Component
```typescript
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class UserProfileComponent {
  protected readonly isServerRunning = signal(true);
  
  user = input.required<User>();
  userSelected = output<User>();
  
  protected buttonClasses = computed(() => 
    `btn btn-${this.variant()}`
  );
  
  toggleServerStatus() {
    this.isServerRunning.update(isServerRunning => !isServerRunning);
  }
}
```

### Template Guidelines
- Use native control flow instead of structural directives
- Avoid `ngClass` and `ngStyle`; use property bindings
- Keep templates simple; extract complex logic to methods
- Use semantic HTML for accessibility

### Services
- Use `providedIn: 'root'` for singleton services
- Use `inject()` function instead of constructor injection
- Design around single responsibility

### UI Component Libraries
- Integrate PrimeNG components for comprehensive UI toolkit
- Use PrimeNG with Angular signals for reactive component state
- Follow PrimeNG accessibility and theming guidelines
- See [PrimeNG Development](#primeng-development) section for detailed integration patterns

## PrimeNG Development

### Modern PrimeNG (v20+)
- **Persona**: Expert in PrimeNG v20+ with Angular v20+ integration
- Use PrimeNG components with Angular signals and standalone architecture
- Leverage comprehensive component library for rapid UI development
- Prioritize accessibility and theming consistency

### Component Integration
- Import specific PrimeNG modules, never the entire library
- Use standalone components with PrimeNG module imports
- Integrate PrimeNG components with Angular signals for reactive state
- Follow PrimeNG accessibility guidelines and ARIA standards

### Best Practices
- Use proper theming with CSS custom properties
- Implement responsive design with PrimeNG's built-in responsiveness
- Optimize performance with lazy loading and OnPush change detection
- Test PrimeNG component interactions thoroughly

### Example PrimeNG Component with Signals
```typescript
@Component({
  selector: 'app-data-table',
  standalone: true,
  imports: [TableModule, ButtonModule],
  template: `
    <p-table 
      [value]="users()" 
      [loading]="loading()" 
      [paginator]="true">
      <!-- Template content -->
    </p-table>
  `,
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class DataTableComponent {
  protected readonly users = signal<User[]>([]);
  protected readonly loading = signal(false);
}
```

### Detailed Guidelines
For comprehensive PrimeNG development guidelines, patterns, and best practices, refer to the dedicated [PrimeNG Guidelines](../junie-guidelines/primeng/primeng-guidelines.md) documentation.

## Tailwind CSS Development

### Modern Utility-First Approach
- **Persona**: Expert in Tailwind CSS 4.1 with Oxide engine
- Use utility-first styling with constraint-based design system
- Apply mobile-first responsive design with breakpoint prefixes
- Leverage state variants (`hover:`, `focus:`, `dark:`)

### Key Concepts
- **Responsive Design**: Use `sm:`, `md:`, `lg:`, `xl:`, `2xl:` prefixes
- **Dark Mode**: Use `dark:` variant for theme-aware styling
- **Arbitrary Values**: Use `[value]` notation for one-off styles
- **State Management**: Use group and peer interactions

### Component Patterns
```html
<!-- Modern responsive card -->
<div class="group relative overflow-hidden rounded-xl bg-white shadow-sm ring-1 ring-gray-200 transition-all duration-200 hover:shadow-md hover:ring-gray-300 dark:bg-gray-900 dark:ring-gray-800">
  <div class="p-6">
    <h3 class="text-lg font-semibold leading-6 text-gray-900 dark:text-white">
      Card Title
    </h3>
  </div>
</div>
```

### Best Practices
- Design mobile-first, enhance for larger screens
- Use consistent spacing scale (4px increments)
- Group utilities logically: layout → spacing → sizing → colors → effects
- Use `@apply` directive sparingly for reusable patterns
- Implement proper dark mode support

## Clean Code Principles

### Meaningful Names
- Use intention-revealing names that express purpose
- Choose searchable names over abbreviations
- Use pronounceable names for team communication
- Avoid mental mapping - be explicit
- Use consistent vocabulary throughout codebase

### Functions and Methods
- Keep functions small and focused (ideally under 20 lines)
- Use descriptive names that indicate purpose
- Limit parameters (0-3 ideal, use objects for more)
- Avoid deep nesting with early returns and guard clauses
- Prefer pure functions without side effects

### Comments and Documentation
- Write self-documenting code minimizing comment needs
- Use documentation comments for public APIs
- Explain "why" not "what" - code shows what it does
- Keep comments current with code changes
- Remove commented code - use version control

### Code Organization
- Group related functionality together
- Use consistent file and folder naming
- Keep imports organized and remove unused ones
- Separate concerns into different modules
- Maintain clear separation between layers

## SOLID Principles

### Single Responsibility Principle (SRP)
- Each class/module should have only one reason to change
- Separate concerns into different classes
- Use composition to combine responsibilities

### Open/Closed Principle (OCP)
- Open for extension, closed for modification
- Use interfaces and abstract classes for extensibility
- Prefer composition over inheritance
- Use strategy pattern for varying algorithms

### Liskov Substitution Principle (LSP)
- Subtypes must be substitutable for base types
- Maintain behavioral contracts in inheritance
- Use structural typing to ensure compatibility

### Interface Segregation Principle (ISP)
- Clients shouldn't depend on unused interfaces
- Create focused, cohesive interfaces
- Split large interfaces into smaller, specific ones

### Dependency Inversion Principle (DIP)
- Depend on abstractions, not concretions
- Use dependency injection for loose coupling
- High-level modules shouldn't depend on low-level modules

## DRY Principles

### Code Duplication Prevention
- Extract common functionality into utilities
- Use generics to avoid type-specific duplication
- Create higher-order functions for repeated patterns
- Use configuration objects instead of hardcoded values

### Knowledge Duplication
- Define types/interfaces once and reuse
- Use constants and enums for shared values
- Create domain-specific libraries
- Document architectural decisions

### Configuration Management
- Use environment files for different configurations
- Extract constants into separate files
- Use dependency injection for configuration
- Create typed configuration objects

## Design Patterns

### Creational Patterns

#### Factory Pattern
```java
public class DatabaseConnectionFactory {
    public static DatabaseConnection create(DatabaseType type) {
        return switch (type) {
            case MYSQL -> new MySQLConnection();
            case POSTGRESQL -> new PostgreSQLConnection();
            case ORACLE -> new OracleConnection();
        };
    }
}
```

#### Builder Pattern
```java
public class User {
    private final String name;
    private final String email;
    
    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
    }
    
    public static class Builder {
        private String name;
        private String email;
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public User build() {
            return new User(this);
        }
    }
}
```

### Behavioral Patterns

#### Strategy Pattern
```java
public interface SortingStrategy {
    <T extends Comparable<T>> void sort(List<T> list);
}

public class Sorter {
    private final SortingStrategy strategy;
    
    public Sorter(SortingStrategy strategy) {
        this.strategy = strategy;
    }
    
    public <T extends Comparable<T>> void sort(List<T> list) {
        strategy.sort(list);
    }
}
```

#### Repository Pattern
```java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
    
    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findActiveUsers();
}
```

### Structural Patterns

#### Adapter Pattern
- Use to integrate legacy systems with modern interfaces
- Transform data between incompatible interfaces
- Maintain clean separation between external and internal APIs

#### Decorator Pattern
- Add behavior to objects without modifying structure
- Compose functionality at runtime
- Follow single responsibility while extending capabilities

## Testing Guidelines

### General Testing Principles
- Write tests using modern frameworks (JUnit 5, Jest)
- Follow AAA pattern: Arrange, Act, Assert
- Use meaningful test names describing scenarios
- Mock dependencies appropriately
- Aim for high test coverage focusing on critical business logic

### Integration Testing
- Use Testcontainers for real service dependencies
- Use random ports to avoid conflicts (`@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)`)
- Test with actual database/message broker instances
- Use specific versions matching production

### Unit Testing
- Test business logic in isolation
- Mock external dependencies
- Verify both happy path and error scenarios
- Use proper type definitions in TypeScript tests

## Performance Considerations

### Java Performance
- Use StringBuilder for string concatenation in loops
- Cache expensive computations appropriately
- Use primitive types when wrapper overhead unnecessary
- Profile before optimizing and measure impact

### Frontend Performance
- Use PurgeCSS or Tailwind's built-in purging for production
- Optimize images and use appropriate formats
- Consider critical CSS extraction for above-fold content
- Implement lazy loading for feature routes (Angular)

### Spring Boot Performance
- Use read-only transactions for queries
- Implement proper connection pooling
- Avoid N+1 queries with proper fetching strategies
- Use caching appropriately for expensive operations

## Accessibility Guidelines

### General Accessibility
- Always include proper ARIA labels and roles
- Ensure keyboard navigation works properly
- Use screen reader utilities for assistive technology
- Maintain proper color contrast ratios
- Test with actual screen readers

### Angular Accessibility
- Use semantic HTML elements with Tailwind classes
- Implement proper focus management
- Provide alternative text for images
- Use Angular CDK for accessibility utilities

### CSS Accessibility
- Ensure sufficient color contrast (4.5:1 for normal text)
- Use relative units for scalability
- Provide focus indicators for interactive elements
- Support reduced motion preferences

## Documentation Standards

### Code Documentation
- Use appropriate documentation systems:
  - JavaDoc for Java public APIs
  - TSDoc for TypeScript public interfaces
  - Component documentation for Angular components
- Document architectural decisions
- Maintain API documentation
- Keep README files current

### Team Communication
- Use consistent terminology across the team
- Document coding conventions and deviations
- Share common patterns through team standards
- Regular review and update of guidelines

---

*Last updated: August 23, 2025*
*Based on junie-guidelines module comprehensive technology guidelines*
