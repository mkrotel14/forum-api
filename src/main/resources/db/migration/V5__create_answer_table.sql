CREATE TABLE answer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    is_correct_answer BOOLEAN NOT NULL DEFAULT FALSE,
    topic_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_answer_topic FOREIGN KEY (topic_id)
        REFERENCES topic(id) ON DELETE CASCADE,
    CONSTRAINT fk_answer_author FOREIGN KEY (author_id)
        REFERENCES forum_user(id) ON DELETE RESTRICT
);

CREATE INDEX idx_answer_topic ON answer(topic_id);
CREATE INDEX idx_answer_author ON answer(author_id);
CREATE INDEX idx_answer_solution ON answer(is_correct_answer);