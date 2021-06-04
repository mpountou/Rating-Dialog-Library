# Rating-Dialog-Library

## Latest Version
[![Release](https://jitpack.io/v/mpountou/Rating-Dialog-Library.svg)](https://jitpack.io/#mpountou/Rating-Dialog-Library)

## Description

A material designed app Rating Dialog for Android 


<img src="screenshot/Animation.gif" width="35%"/>



## Features
- Show dialog on a specific session
- Ask user rate your app
- Don't show dialog again if option never ask again or rate are clicked
- Set custom title / description 
- Set custom text for possitive neutral or negative buttons

## Installation

Add jitpack in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
```

Add the dependency
```
	dependencies {
	
	         implementation 'com.github.mpountou:Rating-Dialog-Library:0.0.1'
	}
```

## How to use

To show rating dialog just add those two lines
```kotlin
var dialogManager = DialogManager(this)
dialogManager.show()
  ```
If you want to use custom title/description 
```kotlin
var dialogManager = DialogManager(this)
// you can use your custom title or let the default
dialogManager.setDialogTitle("Rate My App!!")
// same for description and buttons .. 
dialogManager.show()
  ```
 If you want to show rating dialog to old users
 ```kotlin
var dialogManager = DialogManager(this)
// every time you call the show() method a counter incement the times that app is used
dialogManager.shouldBeUsedMoreThan(3) //(times)
// if user used the app more than 3 times the dialog will be shown
dialogManager.show()
  ```
