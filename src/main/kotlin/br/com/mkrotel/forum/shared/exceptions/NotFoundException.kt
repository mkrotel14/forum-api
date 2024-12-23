package br.com.mkrotel.forum.shared.exceptions

open class NotFoundException(
    message: String = "Resource not found",
    val resourceType: String? = null,
    val resourceId: Any? = null
) : RuntimeException(
    when {
        resourceType != null && resourceId != null -> "$resourceType with id '$resourceId' not found"
        resourceType != null -> "$resourceType not found"
        else -> message
    }
) {
    companion object {
        fun from(resourceType: String, id: Any): NotFoundException {
            return NotFoundException(resourceType = resourceType, resourceId = id)
        }
    }
}

class TopicNotFoundException(topicId: Long) : NotFoundException(
    resourceType = "Topic",
    resourceId = topicId
)

class CourseNotFoundException(courseId: Long) : NotFoundException(
    resourceType = "Course",
    resourceId = courseId
)

class UserNotFoundException(userId: Long) : NotFoundException(
    resourceType = "User",
    resourceId = userId
)

class AnswerNotFoundException(answerId: Long) : NotFoundException(
    resourceType = "Answer",
    resourceId = answerId
)

inline fun <reified T> notFoundException(id: Any): NotFoundException {
    return NotFoundException(resourceType = T::class.simpleName, resourceId = id)
}

