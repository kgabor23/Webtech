# Invoice Kezelő Alkalmazás

## Milyen típusokat/entitásokat kezel az alkalmazás?

Az alkalmazás a következő fő entitásokat kezeli:
- **Invoice (Számla):** A vásárlások adatait tartalmazza, például vásárló neve, posztolási dátum, határidő, tételszám, megjegyzés és ár.
- **User (Felhasználó):** Az alkalmazásba bejelentkezhetnek a felhasználók különböző szerepkörökkel.
- **Role (Szerepkör):** A felhasználók jogosultságait határozza meg (Admin, Könyvelő, Felhasználó).

## Adatbázis séma

Az adatbázis három táblát tartalmaz, amelyek között kapcsolatok találhatóak:
- **Users (Felhasználók):**
  - Oszlopok: `id`, `username`, `password`, `loginDate`, `roles`.
  - Kapcsolat: Many-to-Many kapcsolat a **Roles** táblával.
- **Roles (Szerepkörök):**
  - Oszlopok: `id`, `name`, `description`.
  - Kapcsolat: Many-to-Many kapcsolat a **Users** táblával.
- **Invoices (Számlák):**
  - Oszlopok: `id`, `customer`, `postDate`, `deadline`, `itemNo`, `comment`, `price`.

**Kapcsolatok és számosságok:**
- **Users ↔ Roles:** Sok felhasználóhoz több szerepkör tartozhat (Many-to-Many).
- **Invoices:** Nincs másik táblához kapcsolva, de minden számla egyedi.

## Használt technológiák

Az alkalmazás a következő technológiákat használja:
- **Programozási nyelv:** Java (17-es verzió).
- **Framework:** Spring Boot 3.1.4.
- **Frontend:** Thymeleaf sablonmotor HTML5 támogatással.
- **Adatbázis:** PostgreSQL 42.7.5 verzió.
- **Adatkezelés:** Spring Data JPA.
- **Build és futtatás:** Maven.
- **Kódkiegészítések:** Lombok az egyszerűsített getterek, setterek és konstruktőrök számára.

## Autentikáció

Az alkalmazás nem használ autentikációt.

## Fejlesztési környezet konfigurációja

Az alkalmazás konfigurációja a következő beállításokat tartalmazza:
- **Adatbázis elérhetőség:**
  - URL: `jdbc:postgresql://localhost:5433/invoice`
  - Felhasználónév: `postgres`
  - Jelszó: `admin`
- **Adatbázis kezelés:** `spring.jpa.hibernate.ddl-auto=update`.
- **Statisztikus tartalom útvonala:** `/static/**`.

## Fájlstruktúra

Az alkalmazás főbb fájljai:
- **Entitások:** `com.task.invoice.core.entities` (Invoice, Role, User).
- **DTO-k:** `com.task.invoice.core.dtos` (InvoiceDto, RoleDto, UserDto).
- **Szolgáltatások:** `com.task.invoice.core.services` (Service interface-ek és implementációik).
- **Adatbázis inicializálás:** `DatabaseInitializer` osztály.
- **Konfiguráció:** `WebMvcConfig` és más konfigurációs osztályok.

---

Az alkalmazás célja a számlák kezelésének egyszerűsítése, miközben támogatja a felhasználók és jogosultságok kezelését is. A projekt könnyen bővíthető és konfigurálható a jövőbeni fejlesztésekhez.
