# 📱 Librería Online - Aplicación Android

## 📖 Funcionamiento de la Aplicación

La aplicación **Librería Online** es una biblioteca virtual que muestra una colección de 11 tomos de manhwa "Solo Leveling". Los usuarios pueden:

- **Explorar** la colección a través de una interfaz visual con portadas
- **Ver detalles** completos de cada tomo incluyendo sinopsis
- **Navegar** intuitivamente entre secciones usando la barra inferior
- **Conocer** información sobre el desarrollo en la sección créditos


## 🔧 Configuración de Proyecto Android Nativo

### Procedimiento para crear un proyecto Android nativo en Android Studio:

1. **Abrir Android Studio** y seleccionar "New Project"
2. **Seleccionar tipo de proyecto**: 
   - Elegir "Empty Views Activity" para una actividad base.
   - Esta opción proporciona una estructura mínima ideal para desarrollo personalizado
3. **Configurar detalles del proyecto**:
   - **Nombre**: Libreria Online
   - **Paquete**: com.pantruka.libreriaonline
   - **Ubicación**: Carpeta del proyecto
4. **Configuraciones iniciales esenciales**:
   - **Lenguaje**: Java (seleccionado para este proyecto)
   - **Versión mínima de Android**: API 26 (Android 8.0) - Garantiza compatibilidad con características modernas manteniendo amplio soporte de dispositivos
   - **Tipo de build**: Gradle con Kotlin DSL

### Consideraciones adicionales en la configuración:
- **Estructura de paquetes**: Organización modular por funcionalidad (fragments, adapters, models)
- **Recursos**: Configuración de colores, strings y drawable para consistencia visual
- **Manifest**: Configuración de permisos y actividad principal

## 📦 Manejo de Assets y Recursos

### ¿Qué son los Assets?
Los **assets** son recursos adicionales que se almacenan en la carpeta `assets/` del proyecto Android:
- Archivos que se incluyen en el APK sin compilar
- Se acceden mediante `AssetManager`
- Útiles para recursos que no necesitan ser referenciados por ID

### Diferencia con Drawable:
- **Drawable**: Recursos compilados, accesibles por R.drawable.nombre
- **Assets**: Archivos sin compilar, acceso por ruta de archivo

### Optimización de recursos en este proyecto:
En esta aplicación, las imágenes están en `drawable/` porque:
- Se referencian dinámicamente por nombre desde el código
- Android las optimiza automáticamente según la densidad de pantalla
- Permite mejor rendimiento al compilarse como recursos
- Facilita el mantenimiento y organización del código

Esta decisión optimiza el uso de memoria y mejora el rendimiento de la aplicación.

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos
- **Android Studio**
- **SDK Android** con API level 26 (Android 8.0 o superior)
- **Dispositivo físico** o **emulador** Android 8.0+

### Dispositivo de Pruebas
- **Probada en**: Motorola Moto G71 5G
- **Probada en**: Small Phone de Android Studio


### Pasos de Instalación
1. **Clonar o descargar** el proyecto
2. **Abrir** el proyecto en Android Studio
3. **Sincronizar** las dependencias (Sync Project)
4. **Verificar** que todas las imágenes estén en `/res/drawable/`
5. **Compilar** el proyecto (Build → Make Project)
6. **Ejecutar** en dispositivo/emulador (Run → Run 'app')

### Estructura de Imágenes Requerida
Asegúrate de que existan estos archivos en `/res/drawable/`:
- `logo_libreria` - Logo principal
- `tomo_1` a `tomo_11` - Portadas de los libros
- `ic_home`, `ic_libro`, `ic_info` - Iconos de navegación

## 📦 Dependencias del Proyecto

### Dependencias principales en `build.gradle (Module: app)`:

```gradle
dependencies {
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.fragment:fragment:1.6.1'
    implementation 'androidx.recyclerview:recyclerview:1.3.0'
    implementation 'androidx.cardview:cardview:1.0.0'
    
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
}
```

### Descripción de dependencias utilizadas:
- **androidx.appcompat**: Compatibilidad con versiones anteriores de Android
- **material**: Componentes de Material Design (BottomNavigationView, CardView, etc.)
- **constraintlayout**: Layouts flexibles y responsivos
- **fragment**: Manejo de fragments y navegación
- **recyclerview**: Lista eficiente para mostrar los libros
- **cardview**: Tarjetas con elevación y bordes redondeados

### Configuración en `build.gradle (Module: app)`:
```gradle
android {
    compileSdk 34
    
    defaultConfig {
        applicationId "com.pantruka.libreriaonline"
        minSdk 26
        targetSdk 34
        versionCode 1
        versionName "1.0"
    }
    
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}
```

## 🎯 Decisiones de Desarrollo

### Arquitectura Elegida
- **Bottom Navigation**: Navegación intuitiva y accesible con barra inferior
- **RecyclerView con GridLayoutManager**: Optimización de rendimiento para listas grandes

### Gestión de Datos
- **Datos hardcodeados**: Para simplificar el proyecto académico, evitando bases de datos complejas. Los datos se fijan en el código para evitar el uso de bases de datos; la principal desventaja es que para modificar, agregar o eliminar un libro hay que hacerlo directamente en el código.
- **Serializable en lugar de Parcelable**: Más simple para el paso de objetos entre fragments. Permite que el objeto `Libro` se serialice (convierta en bytes) para pasarlo como parámetro entre fragmentos
- **Identificación dinámica de recursos**: Conversión de strings a resource IDs para flexibilidad

### Navegación
- **Fragment BackStack**: Para navegación natural con botón atrás. Crea una "pila" de fragments como el historial del navegador
- **Factory pattern**: Para creación de fragments con parámetros (`newInstance()`). Método estático que se encarga de crear el fragment y configurar sus argumentos correctamente
- **Interface callbacks**: Comunicación limpia entre adapter y fragment. El adapter "llama de vuelta" al fragment cuando se toca un libro

### Consideraciones de UX/UI
- **ScrollView en detalles**: Para contenido extenso sin limitaciones de pantalla
- **Imágenes optimizadas**: Uso de `centerCrop` para mantener proporciones
- **Feedback visual**: Estados de botones y transiciones suaves
- **Accesibilidad**: ContentDescription en imágenes y textos descriptivos

### Optimizaciones Técnicas
- **ViewHolder pattern**: En RecyclerView para mejor rendimiento
- **Lazy loading**: Creación de fragments solo cuando se necesitan
- **Resource caching**: Aprovechamiento del sistema de recursos de Android

## 🏗️ Arquitectura de la Aplicación

La aplicación sigue el patrón **Fragment-based navigation** con una **Bottom Navigation Bar** para la navegación principal.

## 📁 Estructura del Proyecto

### 📋 Manifest
- **`AndroidManifest.xml`**: Archivo de configuración principal que define permisos, actividades y configuraciones básicas de la aplicación. Establece `MainActivity` como punto de entrada y configura el tema de la app.

### ☕ Código Java (`/java/com.pantruka.libreriaonline/`)

#### Actividades
- **`MainActivity.java`**: 
  - Actividad principal y única de la aplicación
  - Configura la barra de estado con colores personalizados
  - Maneja la **Bottom Navigation Bar** 
  - Controla la navegación entre fragments (Inicio, Libros, Créditos)
  - Administra el contenedor de fragments (`fragment_container`)

#### Fragments (Vistas)
- **`HomeFragment.java`**: 
  - Fragment de bienvenida/inicio
  - Muestra el logo y título de la aplicación
  - Interfaz simple de presentación

- **`LibrosFragment.java`**: 
  - Fragment principal que muestra la colección de libros
  - Implementa **RecyclerView** con **GridLayoutManager** (2 columnas)
  - Crea dinámicamente la lista de 11 tomos de "Solo Leveling"
  - Maneja los clicks en libros para navegar a detalles
  - Implementa la interfaz `OnLibroClickListener`

- **`LibroDetallesFragment.java`**: 
  - Fragment de detalles de un libro específico
  - Recibe un objeto `Libro` como parámetro
  - Muestra imagen ampliada, título y descripción completa
  - Incluye botón "Volver" para regresar a la lista
  - Usa **Fragment BackStack** para navegación

- **`CreditosFragment.java`**: 
  - Fragment informativo sobre el desarrollo
  - Muestra información del desarrollador y proyecto
  - Interfaz estática con información académica

#### Modelos de Datos
- **`Libro.java`**: 
  - Clase modelo que representa un libro
  - Implementa `Serializable` para paso entre fragments
  - Propiedades: código, nombre, descripción, rutaIMG
  - Métodos getter para acceso a los datos

#### Adaptadores
- **`LibroAdapter.java`**: 
  - Adaptador personalizado para **RecyclerView**
  - Patrón **ViewHolder** para eficiencia
  - Maneja la visualización de cada libro en la grilla
  - Convierte nombres de recursos drawable en recursos reales
  - Implementa interfaz de callback para clicks en libros

### 🎨 Recursos (`/res/`)

#### Layouts (Diseño de Interfaces)
- **`activity_main.xml`**: 
  - Layout principal con **ConstraintLayout**
  - Contiene **FrameLayout** para fragments y **BottomNavigationView**
  - Estructura base de la aplicación

- **`fragment_home.xml`**: 
  - Pantalla de inicio centrada
  - Logo principal, título y subtítulo
  - Diseño minimalista de bienvenida

- **`fragment_libros.xml`**: 
  - Layout para la lista de libros
  - **RecyclerView** que ocupa la pantalla completa
  - Título de sección "MANHWA COLLECTION"

- **`fragment_creditos.xml`**: 
  - Interfaz de créditos con **CardViews**
  - Información del desarrollador y proyecto
  - Diseño profesional con elevación y sombras

- **`fragment_detalle_libros.xml`**: 
  - Layout detallado de libro individual
  - **ScrollView** para contenido extenso
  - Imagen destacada, título, descripción y botón volver
  - Uso extensivo de **CardViews** para organización visual

- **`item_libro.xml`**: 
  - Layout individual de cada libro en la grilla
  - **CardView** con imagen, título y botón
  - Diseño optimizado para visualización en grilla

#### Menu
- **`menu_bottom_navigation.xml`**: 
  - Define los elementos del menu inferior
  - Tres opciones: Inicio, Libros, Créditos
  - Iconos y títulos para cada sección

#### Valores (Estilos y Colores)
- **`colors.xml`**: 
  - Paleta de colores de la aplicación
  - Color base: `#2C3E50` (azul oscuro)
  - Variantes y colores complementarios

- **`strings.xml`**: 
  - Recursos de texto centralizados
  - Nombre de la aplicación

#### Drawable
- **Todas las imágenes**: 
  - `logo_libreria`: Logo principal de la aplicación
  - `tomo_1` a `tomo_11`: Portadas de los libros de Solo Leveling
  - `ic_home`, `ic_libro`, `ic_info`: Iconos para navegación

## 🎯 Funcionalidades Principales

1. **Navegación Intuitiva**: Bottom Navigation con 3 secciones principales
2. **Catálogo Visual**: Grilla de libros con imágenes y títulos
3. **Detalles Completos**: Vista expandida con descripción completa
4. **Diseño Responsivo**: Layouts optimizados para diferentes pantallas
5. **Interfaz Moderna**: Diseño limpio con CardViews y elevaciones

## 📱 Flujo de la Aplicación

1. **Inicio**: El usuario ve la pantalla de bienvenida con el logo
2. **Explorar**: Navega a "Libros" para ver la colección
3. **Seleccionar**: Toca "VER DETALLES" en cualquier libro
4. **Leer**: Ve información completa del libro seleccionado
5. **Volver**: Regresa a la lista o navega a otras secciones

## 🔧 Tecnologías Utilizadas

- **Lenguaje**: Java
- **SDK**: Android API 26+ (Android 8.0 o superior)
- **Componentes**: 
  - RecyclerView con GridLayoutManager
  - Fragments y Navigation
  - CardView y ConstraintLayout
  - BottomNavigationView

## 👨‍💻 Desarrollado por
**Ricardo Ruiz Palacios**  
Evaluación Final Módulo 4