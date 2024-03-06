Veterinary Management System API.

This API is developed using Java Spring Boot.
Layered architecture is taken into account. 
It is a product of thinking and working on 
issues such as IoC (Inverse of Control), DI (Dependency Injection), 
annotations (@Entity, @Table, @Id, @OneToMany, @ManyToOne etc.), 
Http statuses, request and response transfers. .


Veterinary Management System Application.
Thanks to this application, an online veterinary management system can be built.
Thanks to the application, the user:
-Can record Veterinary doctors,
-Can record doctors' working days (available days),
-Can register customers,
-Can record customers' animals,
-Can record the vaccines applied to animals with their dates,
-Can make appointments with veterinarians for animals.

Images of the endpoints of the application are below.

###########################################################

Veteriner Yönetim Sistemi API.

Bu API, Java Spring Boot kullanılarak geliştirilmiştir.
Katmanlı mimari dikkate alınmıştır. IoC (Inverse of Control), 
DI (Dependency Injection), anotasyonlar (@Entity, @Table, @Id, @OneToMany, @ManyToOne gibi...), 
Http statüleri, request ve response aktarımları gibi konular üzerine 
düşünmenin ve çalışmanın bir ürünüdür.


Veteriner Yönetim Sistemi Uygulaması.
Bu uygulama sayesinde online veteriner yönetim sistemi kurulabilmektedir.
Uygulama sayesinde kullanıcı:
-Veteriner hekimleri kaydedebilir,
-Doktorların çalışma günlerini (mevcut günleri) kaydedebilir,
-Müşteri kaydı yapabilir,
-Müşterilerin hayvanlarını kaydedebilir,
-Hayvanlara uygulanan aşıları tarihleriyle birlikte kaydedebilir,
-Hayvanlar için veteriner hekimlerden randevu alabilir.


###########################################################

**-UML Diagram:**
![Uml Diagram](vet_management_endpoints_ss/vet_management_uml_diagram.png)

**-Application description:**
![Description](vet_management_endpoints_ss/vet_management_description.png)

**Animal Entity:**

-animal save:
![Animal Save](vet_management_endpoints_ss/animal/animal_save.png)

-animal get:
![Animal Get](vet_management_endpoints_ss/animal/animal_get.png)

-animal update:
![Animal Update](vet_management_endpoints_ss/animal/animal_update.png)

-animal delete:
![Animal Delete](vet_management_endpoints_ss/animal/animal_delete.png)

-find animal by animal name:
![Find By Name](vet_management_endpoints_ss/animal/animal_findByName.png)

-find animal by owner id
![Find By Owner Id](vet_management_endpoints_ss/animal/animal_findByOwnerId.png)

-find all pageable:
![find all](vet_management_endpoints_ss/animal/animal_pageable_response.png)


**Customer Entity**

-customer save:
![Customer Save](vet_management_endpoints_ss/customer/customer_save.png)

-customer get:
![Customer Get](vet_management_endpoints_ss/customer/customer_get.png)

-customer update:
![Customer Update](vet_management_endpoints_ss/customer/customer_update.png)

-customer delete:
![Customer Delete](vet_management_endpoints_ss/customer/customer_delete.png)

-customer find by name:
![Customer find by name](vet_management_endpoints_ss/customer/customer_findByName.png)

-customer find all pageable:
![find all ](vet_management_endpoints_ss/customer/customer_pageable_response.png)


**Doctor Entity**

-doctor save:
![Doctor Save](vet_management_endpoints_ss/doctor/doctor_save.png)

-doctor get:
![Doctor get](vet_management_endpoints_ss/doctor/doctor_get.png)

-doctor update:
![Doctor update](vet_management_endpoints_ss/doctor/doctor_update.png)

-doctor delete:
![Doctor update](vet_management_endpoints_ss/doctor/doctor_delete.png)

-doctor find all pageable:
![Doctor find all](vet_management_endpoints_ss/doctor/doctor_pageable_response.png)


**Appointment Entity**

-appointment save:
![appointment save](vet_management_endpoints_ss/appointment/appointment_save.png)

-appointment get:
![appointment get](vet_management_endpoints_ss/appointment/appointment_get.png)

-appointment update:
![appointment update](vet_management_endpoints_ss/appointment/appointment_update.png)

-appointment delete:
![appointment delete](vet_management_endpoints_ss/appointment/appointment_delete.png)

-appointment find all pageable:
![appointment find all](vet_management_endpoints_ss/appointment/appointment_pageable_response.png)

-appointment find by animal id:
![find by animal id](vet_management_endpoints_ss/appointment/appointment_findByAnimalId.png)

-appointment find by animal id and date between:
![find by animal id and date between](vet_management_endpoints_ss/appointment/appointment_findByAnimalIdAndDateBetween.png)

-appointment find by doctor id:
![find by doctor id](vet_management_endpoints_ss/appointment/appointment_findByDoctorId.png)

-appointment find by doctor id and date between:
![find by doctor id and date between](vet_management_endpoints_ss/appointment/appointment_findByDoctorIdAndDateBetween.png)


**Available Date Entity:**

-available date save:
![available date save](vet_management_endpoints_ss/available_date/available_date_save.png)

-available date get:
![available date get](vet_management_endpoints_ss/available_date/available_date_get.png)

-available date update:
![available date update](vet_management_endpoints_ss/available_date/available_date_update.png)

-available date delete:
![available date delete](vet_management_endpoints_ss/available_date/available_date_delete.png)

-available date find all pageable:
![available date find all pageable](vet_management_endpoints_ss/available_date/available_date_pageable_response.png)


**Vaccine Entity:**

-vaccine save:
![vaccine save](vet_management_endpoints_ss/vaccine/vaccine_save.png)

-vaccine get:
![vaccine get](vet_management_endpoints_ss/vaccine/vaccine_get.png)

-vaccine update:
![vaccine update](vet_management_endpoints_ss/vaccine/vaccine_update.png)

-vaccine delete:
![vaccine delete](vet_management_endpoints_ss/vaccine/vaccine_delete.png)

-vaccine find all pageable:
![vaccine find all](vet_management_endpoints_ss/vaccine/vaccine_pageable_response.png)

-vaccine find by animal id:
![vaccine find by animal id](vet_management_endpoints_ss/vaccine/vaccine_findByAnimalId.png)

-vaccine find by animal id and date between:
![date between](vet_management_endpoints_ss/vaccine/vaccine_findByAnimalIdAndDateBetween.png)

-vaccine find by date between:
![date between](vet_management_endpoints_ss/vaccine/vaccine_findByDateBetween.png)