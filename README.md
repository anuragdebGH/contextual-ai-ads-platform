# Contextual AI Ads Platform

**A project that uses AI and NLP to analyze advertisement content for sentiment, keyword extraction, and contextual insights. Designed for seamless integration into business systems to enhance ad targeting and effectiveness.**

---

## Table of Contents

1. [Introduction](#introduction)
2. [Key Features](#key-features)
3. [Architecture Overview](#architecture-overview)
4. [Installation](#installation)
5. [Usage](#usage)
6. [API Endpoints](#api-endpoints)
7. [License](#license)
8. [Acknowledgments](#acknowledgments)

---

## Introduction

The **Contextual AI Ads Platform** processes ad content using Natural Language Processing (NLP) to deliver actionable insights. It enables organizations to analyze ad copy for sentiment, extract relevant keywords, and integrate contextual analysis into their ad-serving systems. Built with Java, Python, and Kafka, the platform is scalable, modular, and supports real-time processing.

---

## Key Features

- **Sentiment Analysis**: Detect if an advertisement's tone is positive, neutral, or negative.
- **Keyword Extraction**: Identify key phrases from ad descriptions to optimize targeting.
- **Real-time Processing**: Powered by Apache Kafka for streaming data and event-driven architecture.
- **Scalable Design**: Modular architecture for easy integration and future feature enhancements.
- **Comprehensive API**: RESTful API endpoints for ad management and NLP results retrieval.
- **Cross-Platform Support**: Built with Java for backend services and Python for NLP analysis.

---

## Architecture Overview

The platform is built using a microservices-based architecture:

1. **Backend Service (Java)**:
    - Handles REST API endpoints for ad creation, updates, and retrieval.
    - Sends ad creation events to Kafka topics.
    - Consumes processed data from Kafka for storage and retrieval.

2. **NLP Service (Python)**:
    - Listens to Kafka topics for incoming ad data.
    - Processes ad descriptions using `TextBlob` for sentiment analysis and keyword extraction.
    - Publishes enriched data back to Kafka topics.

3. **Apache Kafka**:
    - Acts as the message broker for communication between services.
    - Handles topics such as `ads-created` and `ads-analyzed`.

---

## Installation

### Prerequisites

- **Java 17+**
- **Maven 3.6+**
- **Python 3.9+** with the following libraries:
    - `confluent-kafka`
    - `textblob`
- **Apache Kafka and Zookeeper** (running locally or in Docker).


### Steps to Install

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/contextual-ai-ads-platform.git
   cd contextual-ai-ads-platform

2. **Build and Run the Backend Service**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   
3. **Set up Kafka and Zookeeper**
   ```bash
   bin/zookeeper-server-start.sh config/zookeeper.properties
   bin/kafka-server-start.sh config/server.properties

4. **Run the NLP Service**
   - Navigate to the `python-nlp-api` directory and start the Python service:
   ```bash
   cd python-nlp-api
   python app.py

5. **Create Kafka Topics**
   - Create the necessary Kafka topics for the project:
   ```bash
   bin/kafka-topics.sh --create --topic ads-created --bootstrap-server localhost:9092
   bin/kafka-topics.sh --create --topic ads-analyzed --bootstrap-server localhost:9092

6. **Verify the Setup**
   - Check if the backend service, Kafka, and NLP service are running successfully:
   - Backend service logs should indicate successful startup.
   - Kafka logs should confirm the broker is running.
   - The Python NLP service should log: `INFO:NLP-ConfluentKafka-Processor:Starting NLP Kafka Integration Service...`

---

## Usage
### Example Workflow

1. **Create an Ad:** Use the following curl command to create an ad via the API:
   ```bash
   curl -X POST http://localhost:8080/ads \
   -H "Content-Type: application/json" \
   -d '{"headline": "50% Off Sale", "description": "Massive discounts on summer collections!"}'
2. **Process the Ad:**

   - The ad will be sent to the Kafka topic ads-created.
   - The NLP service will process the ad for sentiment and keyword extraction.
   - The enriched data will be published to the ads-analyzed topic and stored in the database.

3. **Retrieve Processed Ads:** Fetch the analyzed ad data using the following curl command:

   ```bash
   curl -X GET http://localhost:8080/ads/1

4. **Monitor Kafka Topics:** Use the following commands to consume messages from the Kafka topics:

   - Consume from `ads-created`:

     ```bash
     bin/kafka-console-consumer.sh --topic ads-created --bootstrap-server localhost:9092 --from-beginning

   - Consume from `ads-analyzed`:
     ```bash
     bin/kafka-console-consumer.sh --topic ads-analyzed --bootstrap-server localhost:9092 --from-beginning

---

## API Endpoints
### Ad Management Endpoints
- Create Ad: `POST /ads`
- Get All Ads: `GET /ads`
- Get Ad by ID: `GET /ads/{id}`
- Update Ad: `PUT /ads/{id}`
- Delete Ad: `DELETE /ads/{id}`
### Kafka Topics
- `ads-created`: For newly created ads.
- `ads-analyzed`: For processed ads with sentiment and keywords.

---

## License
This project is licensed under the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0).

---

## Acknowledgments
Thanks to the open-source community for tools like `Spring Boot`, `Apache Kafka`, and `TextBlob` that made this project possible.
