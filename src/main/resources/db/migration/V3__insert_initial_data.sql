-- Insert some initial users
INSERT INTO forum_user (name, email) VALUES
    ('John Doe', 'john.doe@example.com'),
    ('Jane Smith', 'jane.smith@example.com'),
    ('Admin User', 'admin@example.com');

-- Insert some initial courses
INSERT INTO course (name, category) VALUES
    ('Spring Boot', 'Backend Development'),
    ('Kotlin Fundamentals', 'Programming Language'),
    ('Domain-Driven Design', 'Software Architecture'); 