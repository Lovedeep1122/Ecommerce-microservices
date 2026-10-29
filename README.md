# Event-Driven E-Commerce Microservices

A scalable, event-driven microservices architecture for an e-commerce platform. This project demonstrates asynchronous communication between decoupled services using Apache Kafka.

## Architecture Overview

The system consists of three core microservices:
* **Order Service (Producer):** Receives HTTP POST requests to place orders and publishes an `order-placed` event to Kafka.
* **Notification Service (Consumer):** Listens to the `order-placed` Kafka topic and processes asynchronous notifications (e.g., email or SMS alerts).
* **Inventory Service:** Manages product stock and availability.

## Tech Stack

* **Language:** Java
* **Framework:** Spring Boot 3.x
* **Message Broker:** Apache Kafka
* **Containerization:** Docker & Docker Compose
* **Build Tool:** Maven

## Prerequisites

* Java 17 or higher
* Docker Desktop (running)
* Maven

## How to Run Locally

1. **Start Kafka and Zookeeper via Docker**
   Navigate to the directory containing your `docker-compose.yml` and run:
   ```bash
   docker-compose up -d
