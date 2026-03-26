# 🃏 JCarioca

> Juego de cartas estilo Carioca/Rummy implementado en Java

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=flat&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4-6DB33F?style=flat&logo=spring-boot)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?style=flat&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-green)

---

## ⚠️ Estado del Proyecto

```
┌─────────────────────────────────────────────────────────────┐
│  🚧 PROYECTO EN CONSTRUCCIÓN 🚧                            │
│                                                             │
│  Esta versión es un prototipo funcional básico.             │
│  Las reglas completas del Carioca están siendo             │
│  implementadas.                                            │
└─────────────────────────────────────────────────────────────┘
```

### ✅ Completado

- Sistema de barajas y mazos
- Mezclador de cartas
- Reparto de cartas a jugadores
- Turnos entre jugadores
- Sistema de juego por consola (CLI)
- Logging con SLF4J

### 🔄 En Progreso

- Validación de combinaciones (tríos, escaleras)
- Sistema de puntos
- Condiciones de victoria

### 📋 Por Hacer

- Interfaz gráfica (GUI)
- Modo multijugador online
- Tests unitarios
- Documentación completa

---

## 🕹️ Cómo Jugar

```bash
# Compilar el proyecto
mvn clean compile

# Ejecutar el juego
mvn spring-boot:run
```

### Controles

| Opción | Acción |
|--------|--------|
| 1 | Ver montoncito (descarte) |
| 2 | Tomar carta del montoncito |
| 3 | Tomar carta del mazo |
| 4 | Jugar una carta |
| 5 | Ver mis cartas |
| 0 | Salir |

---

## 🏗️ Estructura del Proyecto

```
src/main/java/cl/prezdev/carioca/
├── Application.java    # Spring Boot main class
├── Menu.java          # Componente CLI del juego
├── cards/             # Cartas, barajas y mazos
│   ├── Card.java
│   ├── Deck.java
│   ├── Joker.java
│   ├── Shoe.java
│   └── Suit.java
├── game/              # Lógica del juego
│   ├── Carioca.java
│   ├── Game.java
│   └── Player.java
└── util/              # Utilidades
    └── Shuffler.java
```

### Paquete

```
cl.prezdev.carioca
```

---

## 🛠️ Tecnologías

- **Java 17**
- **Spring Boot 3.4**
- **Maven 3.9+**
- **SLF4J** (logging)
- **Lombok**

---

## 📝 Licencia

MIT License - feel free to use this project

---

## 👤 Autor

Desarrollado por [@prezdev88](https://github.com/prezdev88)

---

<div align="center">

⭐️ *Si te gusta este proyecto, dale una estrella!* ⭐️

</div>
