CREATE TABLE topic (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING_REPLY',
    author_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_topic_author FOREIGN KEY (author_id)
        REFERENCES forum_user(id) ON DELETE RESTRICT,
    CONSTRAINT fk_topic_course FOREIGN KEY (course_id)
        REFERENCES course(id) ON DELETE RESTRICT
);

CREATE INDEX idx_topic_author ON topic(author_id);
CREATE INDEX idx_topic_course ON topic(course_id);
CREATE INDEX idx_topic_status ON topic(status);