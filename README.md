# hrmsBackendProject
Human Resource Management System Backend Project

## Geliştirme Aşamasında!
### kodlama.io isterleri doğrultusunda geliştirilmektedir!

> Spring Boot ile geliştirilmeye başlandı.
> 
> Veritabanı oluşturuldu ve bazı tablolar eklendi.
> 
> "positions" tablosu için nesne, manager ve controller eklendi.


# Old Database Diagram
## Not: Hatalarımı gözlemlemek adına bunu burada tutma kararı aldım
![databasediagram](https://raw.githubusercontent.com/salihdeg/gitHubImages/master/hrmsBackendImages/hrmsDatabaseDiagram.png)

# 30.05.2021 Tarihli Commit'ler ile yapılan büyük eklemeler ve değişiklikler

> 23.05.2021 tarihinden itibaren deneme, yanılma yolu ile bir çok değişikliği oldu
> Şuanda göremediğiniz bir sürü değişiklik sebebi ile geliştirme süreci bitene kadar commit atmadım
> 
> Swagger Desteği eklendi
> 
> Database, isterler tekrar düşünülerek yeniden oluşturuldu.
> 
> User'dan inherit olan Workers, Employers ve System Employees tabloları için entity, dao, manager ve controller'lar eklendi.
> 
> Email ve Admin Verification için Tablolar, Sınıflar ve Manager'lar eklendi.
> 
> Workers ve Employers için istenen iş kuralları yazıldı.
> 
> Şuanda sadece Employers için bir register işlemi mevcut, ilerleyen commit'lerde Diğer User tipleri için de register-login işlemleri eklenecek.

## Database Diagram - 30.05.2021
![databasediagram](https://raw.githubusercontent.com/salihdeg/gitHubImages/master/hrmsBackendImages/hrmsDatabaseDiagram-30.05.2021.png)

# 01.06.2021 Tarihli Değişiklikler

> Job Advertisements için Entity, Repository, Service ve Controller oluşturuldu.

## Database Diagram - 01.06.2021
### Diagram oluşturma PostgreSql Üzerinde henüz beta olduğu için çok hoş görselle oluşmuyor bu yüzden DbVisualizer kullandım, tavsiye ederim.
![databasediagram](https://raw.githubusercontent.com/salihdeg/gitHubImages/master/hrmsBackendImages/hrms_ERD_1Jun2021.png)

