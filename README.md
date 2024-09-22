# Benchmark Java CloudNative

**Benchmark Java CloudNative** is a repository designed for performance testing and benchmarking of Java applications in cloud-native environments. The project integrates Jakarta EE 10 and Apache JMeter, providing tools for scalable and reliable service optimization. Future comparisons will be made with Quarkus, Quarkus Native, Quarkus Reactive, and Quarkus Reactive Native to analyze performance across different Java frameworks.

## Key Features

- **Jakarta EE 10 REST Services**: Build enterprise-level Java RESTful APIs with Jakarta EE 10.
- **JMeter Performance Benchmarking**: Comprehensive performance testing using Apache JMeter, tailored for cloud environments.
- **Planned Comparisons**: Future performance benchmarks will include comparisons with Quarkus and its various modes (Native, Reactive, and Reactive Native).

## Getting Started

### Prerequisites

To get started, make sure you have the following installed:

- **Java 17** (or later, currently using Java 22)
- **Maven** (compatible with Java 17+)
- **Apache JMeter**
- **JBang** (for running Java applications easily)
- **TomEE** (latest version compatible with Java 17)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/3bento/benchmark_java_cloudnative.git
   cd benchmark_java_cloudnative
   ```

2. Follow the installation steps for each specific module.

### Jakarta EE 10 REST Service

- **Requirements**: Java 17+, Maven, TomEE (latest compatible with Java 17)
- **Setup**:
    1. Build the project using Maven:

       ```bash
       mvn clean install
       ```

    2. Deploy the Jakarta EE 10 REST service to your TomEE server.

    3. Access the REST API at `/api/docs` for more information on available endpoints.

### Benchmarking Module

- **Requirements**: Java 17+, JBang, Apache JMeter
- **Setup**:
    1. Run the JMeter performance tests with the provided `.jmx` file:

       The `jmeter_benchmark_jakartaee10rest.jmx` contains the performance test configuration, specifically targeting the Jakarta EE 10 REST service.

       **Warning**: This test is configured to make **1,000,000 requests** in total. Be sure to validate the volume before proceeding to avoid overwhelming your system.

    2. To execute JMeter without needing the GUI, use `BenchmarkJmeterRun.java`, which requires JBang. This script will automatically run the JMeter benchmark for you from the terminal:

       ```bash
       jbang BenchmarkJmeterRun.java
       ```

    3. After the test completes, results will be saved in the `benchmark/jmeter/result/` folder. A detailed web report can be found under:

       ```bash
       benchmark/jmeter/result/report/{date_time}_report_web/
       ```

## Future Work

We plan to extend this benchmarking suite to include performance comparisons with Quarkus, Quarkus Native, Quarkus Reactive, and Quarkus Reactive Native. This will provide valuable insights into the performance differences between Jakarta EE 10 and these alternative frameworks in cloud-native environments.

## Contributing

We welcome contributions! Feel free to fork the repository, create a branch, and submit a pull request.

## License

This project is licensed under the GPL-3.0 License.