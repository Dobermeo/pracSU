package com.example.suple.model

import com.example.suple.repository.TeacherRepository
import com.example.suple.service.TeacherService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TeacherServiceTest {

  @InjectMocks
  lateinit var teacherService: TeacherService

  @Mock
  lateinit var teacherRepository: TeacherRepository


  @Test
  fun `Test de campo id`() {
    val teacher = Teacher()
    Mockito.`when`(teacherRepository.save(teacher)).thenAnswer { invocation ->
      val arg = invocation.getArgument(0) as Teacher
      arg.id = 1L
      arg
    }
    teacher.id = 1L
    Assertions.assertEquals(1L, teacher.id)
  }


  @Test
  fun `Test de campo fullname`() {
    val teacher = Teacher()
    Mockito.`when`(teacherRepository.save(teacher)).thenAnswer { invocation ->
      val arg = invocation.getArgument(0) as Teacher
      arg.id = 1L
      arg
    }
    teacher.fullname = "David Bermeo"
    Assertions.assertEquals("David Bermeo", teacher.fullname)
  }
  var teacherMock = Teacher().apply{
    id=1
    fullname="David Bermeo"
    email="dobermeo@sudamericano.edu.ec"
    phone=959119589
  }

  @Test
  fun validationemail(){
    Mockito.`when`(teacherRepository.save(Mockito.any(Teacher::class.java))).thenReturn(teacherMock)
    teacherMock.email?.contains("@")?.let { Assertions.assertTrue(it) }
    val response = teacherService.save(teacherMock)
    Assertions.assertEquals(response?.id, teacherMock.id)
  }

  @Test
  fun `Test de campo phone`() {
    val teacher = Teacher()

    Mockito.`when`(teacherRepository.save(teacher)).thenAnswer { invocation ->
      val arg = invocation.getArgument(0) as Teacher
      arg.id = 1L
      arg
    }

    teacher.phone = 959119589
    Assertions.assertEquals(959119589, teacher.phone)
  }
}





