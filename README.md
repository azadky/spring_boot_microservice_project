# Microservice School Application

Bu proje, **Spring Boot**, **Spring Cloud**, **Spring Cloud Config**, **Eureka Discovery**, **Spring Cloud Gateway**, **OpenFeign**, **Zipkin**, ve **Docker Compose** kullanılarak oluşturulmuş bir mikroservis uygulamasıdır. Projede iki ana mikroservis bulunmaktadır: **Student Service** ve **School Service**. Bu servisler birbirleriyle haberleşerek öğrencilerin ve okulların bilgilerini yönetir.

## 🧩 Mikroservisler

### 1. Config Server (`config-server`)
- Yapılandırma dosyalarını merkezi olarak yönetir.
- Port: `8888`

### 2. Eureka Discovery Server (`discovery`)
- Tüm mikroservislerin birbirini bulmasını sağlar.
- Port: `8761`

### 3. API Gateway (`gateway`)
- Tüm servisler için giriş noktasıdır.
- `students` ve `schools` rotalarını yönlendirir.
- Port: `8222`

### 4. Student Service (`student`)
- Öğrencilerin bilgilerini tutar.
- Port: `8090`

### 5. School Service (`school`)
- Okul bilgilerini tutar ve ilgili öğrenci listesini `student` servisi üzerinden çeker.
- Port: `8070`
- Feign Client aracılığıyla `student` servisine bağlanır.

### 6. Zipkin (`zipkin`)
- Dağıtık izleme ve tracing sağlar.
- Port: `9411`

## 🏗️ Yapı

- **Veritabanı**: `MySQL 8`, `microservice_db` isimli bir veritabanı ile çalışır.
- **Spring Cloud OpenFeign**: Servisler arası iletişim sağlar (özellikle `school` -> `student`).
- **Actuator ve Zipkin**: İzleme, tracing ve debugging için entegre edilmiştir.

## 📁 Örnek API'ler

### SchoolController
- `POST /api/v1/schools` — Yeni okul kaydı.
- `GET /api/v1/schools` — Tüm okulları getirir.
- `GET /api/v1/schools/with-students/{schoolId}` — Okul ve bağlı öğrencileri getirir.

## ⚙️ Projeyi Çalıştırma

### 1. Gereksinimler
- Docker & Docker Compose
- Java 17+
- Maven

### 2. Docker Compose ile Başlatma

```bash
docker-compose up --build
```

Servislerin sırasıyla ayağa kalkmasını bekleyin:

- MySQL
- config-server
- discovery
- gateway
- student
- school
- zipkin

### 3. Servis Erişimleri

| Servis        | URL                                 |
|---------------|--------------------------------------|
| Config Server | http://localhost:8888                |
| Eureka        | http://localhost:8761                |
| Gateway       | http://localhost:8222                |
| Student       | http://localhost:8090/api/v1/students |
| School        | http://localhost:8070/api/v1/schools |
| Zipkin        | http://localhost:9411                |

## 🧪 Test Verisi

### Örnek JSON:
```json
{
  "name": "Example School",
  "email": "school@example.com"
}
```

## 📂 Proje Modülleri

- `School.java`: Okul Entity sınıfı
- `Student.java`: Öğrenci model sınıfı
- `SchoolController`: REST API controller
- `SchoolService`: İş servis katmanı
- `StudentClient`: OpenFeign ile student servisi çağrısı
- `FullSchoolResponse`: Okul ve öğrenci listesini içeren DTO

## 📦 Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.4.3
- Spring Cloud 2024.0.0
- Spring Data JPA
- Eureka Server & Client
- Spring Cloud Gateway
- Spring Cloud Config Server
- OpenFeign
- MySQL
- Zipkin (Tracing)
- Docker & Docker Compose

## ✍️ Geliştirici

- **Azad Kaya** — [GitHub](https://github.com/azadky)