package br.com.mkrotel.forum.features.topic.application

import br.com.mkrotel.forum.features.topic.domain.model.Topic
import br.com.mkrotel.forum.features.topic.application.dto.answer.AnswerRequest
import br.com.mkrotel.forum.features.topic.application.dto.topic.TopicRequest
import br.com.mkrotel.forum.features.topic.application.dto.topic.TopicResponse
import br.com.mkrotel.forum.features.topic.application.dto.answer.AnswerResponse
import br.com.mkrotel.forum.features.topic.application.dto.answer.UpdateAnswerRequest
import br.com.mkrotel.forum.features.topic.application.dto.topic.UpdateTopicRequest
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/topics")
class TopicController(
    private val topicService: TopicService,
    private val answerService: AnswerService
) {

    @GetMapping
    fun getAllTopics(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): ResponseEntity<Page<TopicResponse>> {
        val pageable = PageRequest.of(page, size)
        val response = topicService.getAllTopics(pageable)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): ResponseEntity<Topic> {
        val response = topicService.getTopicById(id)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun createTopic(@RequestBody @Valid body: TopicRequest): ResponseEntity<Topic> {
        val response = topicService.createTopic(body)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response)
    }

    @PutMapping("/{id}")
    fun updateTopic(
        @PathVariable id: Long,
        @RequestBody @Valid body: UpdateTopicRequest
    ): ResponseEntity<Topic> {
        val response = topicService.updateTopic(id, body)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        topicService.deleteTopic(id)
    }

    @PostMapping("/{id}/answer")
    fun createTopicAnswer(@PathVariable id: Long, @RequestBody @Valid body: AnswerRequest): ResponseEntity<AnswerResponse> {
        val response = answerService.createAnswer(id, body)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(response)
    }

    @PutMapping("/{id}/answer")
    fun updateTopicAnswer(@PathVariable id: Long, @RequestBody @Valid body: UpdateAnswerRequest): ResponseEntity<AnswerResponse> {
        val response = answerService.updateAnswer(body)
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}/answer/{answerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopicAnswer(
        @PathVariable id: Long,
        @PathVariable answerId: Long
    ) {
        answerService.deleteAnswer(answerId)
    }
}