# Dicoding Intermediate Story App

This repository contains the project submission for the **Dicoding Intermediate Android Developer Course** completed on **May 25, 2023**. The app allows users to submit and view stories (photos) with **paging** support to enhance performance and user experience.

## Submission Date

This project was submitted on **May 25, 2023** as part of the requirements for the Dicoding Intermediate Android Developer Course.

## Features

- **User Authentication**: Users can register, log in, and log out.
- **Submit Stories with Photos**: Users can submit stories along with photos taken from their devices.
- **Paging for Story Feed**: Story feed is implemented using paging to provide smooth and efficient scrolling.
- **Location Integration**: Displays stories along with the geographic location where the photo was taken.
- **Camera and Gallery Integration**: Users can upload photos directly from the camera or from the gallery.
- **Story Detail View**: Users can click on a story to view more details, including the photo, description, and location.

## Technology Stack

- **Kotlin**: The primary programming language used for Android development.
- **Android Jetpack**: Utilized components like Paging, ViewModel, and LiveData to improve the app's architecture and performance.
- **Retrofit**: For making API requests to the backend server.
- **Coroutines**: For asynchronous programming and handling background tasks.
- **Glide**: For image loading and caching.
- **Room Database**: Local database for caching story data.
- **Fused Location Provider**: To get the user's location.

## How to Run

1. Clone this repository:
    ```bash
    git clone https://github.com/yourusername/dicoding-intermediate-story-app.git
    ```
2. Open the project in **Android Studio**.
3. Build and run the project on an Android device or emulator.
