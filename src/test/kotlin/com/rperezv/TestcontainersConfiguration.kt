package com.rperezv

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	@Bean
	@ServiceConnection
	fun postgresContainer(): PostgreSQLContainer<*> {
		var dockerImage = DockerImageName.parse("public.ecr.aws/docker/library/postgres:latest").asCompatibleSubstituteFor("postgres")
		return PostgreSQLContainer(dockerImage)
			.withDatabaseName("movie")
			.withInitScript("init-db.sql")
	}

}
