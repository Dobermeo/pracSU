package com.example.suple.service

import com.example.suple.model.Subject
import com.example.suple.model.Teacher
import com.example.suple.repository.SubjectRepository
import com.example.suple.repository.TeacherRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class SubjectServiceTest {

  @Mock
  lateinit var subjectRepository: SubjectRepository

  @Mock
  lateinit var teacherRepository: TeacherRepository


  @InjectMocks
  lateinit var subjectService: SubjectService

  var subjectMock = Subject().apply {
    id = 1
    description = "hola"
    course = 2
    teacherId = 1
  }

  @Test
  fun `Test de campo id`() {
    val subject = Subject()
    Mockito.`when`(subjectRepository.save(subject)).thenAnswer { invocation ->
      val arg = invocation.getArgument(0) as Subject
      arg.id = 1L
      arg
    }
    subject.id = 1L
    Assertions.assertEquals(1L, subject.id)
  }

  @Test
  fun `Test de campo fullname`() {
    val subject = Subject()
    Mockito.`when`(subjectRepository.save(subject)).thenAnswer { invocation ->
      val arg = invocation.getArgument(0) as Subject
      arg.id = 1L
      arg
    }
    subject.description = "hola"
    Assertions.assertEquals("hola", subject.description)
  }

  @Test
  fun `Test de campo course`() {
    val subject = Subject()

    Mockito.`when`(subjectRepository.save(subject)).thenAnswer { invocation ->
      val arg = invocation.getArgument(0) as Teacher
      arg.id = 1L
      arg
    }

    subject.course = 2
    Assertions.assertEquals(2, subject.course)
  }




}
