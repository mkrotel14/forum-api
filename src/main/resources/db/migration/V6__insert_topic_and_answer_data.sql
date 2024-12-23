-- Insert some sample topics
INSERT INTO topic (title, message, author_id, course_id, status) VALUES
    ('Getting Started with Kotlin', 'How do I set up a Kotlin project?', 1, 2, 'PENDING_REPLY'),
    ('Spring Boot Best Practices', 'What are the current best practices for Spring Boot 3?', 2, 1, 'SOLVED'),
    ('DDD Implementation Questions', 'How to structure a DDD project?', 3, 3, 'PENDING_REPLY');

-- Insert some sample answers
INSERT INTO answer (message, is_correct_answer, topic_id, author_id) VALUES
    ('First install IntelliJ IDEA...', false, 1, 2),
    ('Use Spring Initializr to create a new project...', true, 2, 3),
    ('Follow the standard layered architecture...', false, 2, 1),
    ('Start by identifying your bounded contexts...', false, 3, 2);