package com.rperezv

import com.rperezv.domain.Genre
import com.rperezv.dto.MovieDto
import mu.KLogging
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertNotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Import
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.RequestEntity
import java.net.URI


@Import(TestcontainersConfiguration::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieServiceApplicationTests {

	companion object : KLogging()

	@Autowired
	lateinit var template: TestRestTemplate

	@Test
	fun contextLoads() {
	}

	@Test
	fun health() {
		var responseEntity = template.getForEntity("/actuator/health", String::class.java);
		logger.info("response: {}", responseEntity.body)
		Assertions.assertTrue(responseEntity.statusCode.is2xxSuccessful)
	}

	@Test
	fun allMovies() {

		var movies = getMovies("/api/movies");
		Assertions.assertEquals(6, movies.size);

	}

	@Test
	fun moviesByGenre() {

		var movies = getMovies("/api/movies/ACTION");
		Assertions.assertEquals(3, movies.size);
		assertTrue(movies.all { it.genre == Genre.ACTION })

	}

	fun getMovies(uri: String): List<MovieDto> {
		val requestEntity = RequestEntity.get(URI.create(uri)).build()

		val responseEntity = template.exchange(
			requestEntity,
			object : ParameterizedTypeReference<List<MovieDto>>() {}
		)

		val body = responseEntity.body
		logger.info("response: {}", body)
		assertNotNull(body)

		return body!!
	}
}
