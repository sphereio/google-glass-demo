Google Glass Sphere.io Demo
===========================
[![Build Status](https://travis-ci.org/sphereio/google-glass-demo.svg?branch=develop)](https://travis-ci.org/sphereio/google-glass-demo)

This sample application allows to buy products managed in sphere.io using a google glass device.

- scan a product QR code (contains product SKU) and see the product details loaded from sphere.io
- Buy product: Product will be added to the cart and an order is created in sphere.io
- Scan another product: skip current product and scan another product QR code

This sample inserts a live card to the left of the Glass clock that displays a
compass. Tapping the live card presents a menu with two options:

## Getting started

Check out our documentation to learn how to get started on
https://developers.google.com/glass/gdk/index

## Running the demo on Glass

There are two ways of launching the app. Via touch or using voice commands. From the main menu on the device you will see the following screen

![Alt text](/resources/1.png?raw=true)

Here you can say "start shopping" or touch the menu item.

![Alt text](/resources/2.png?raw=true)

A loading screen will appear. This screen will remain while the login process is running. Everytime the app is launched, the login will be done.

![Alt text](/resources/3.png?raw=true)

Once the Login process is completed, you will be able to scan the QR code. It is important to check the QR size and the distances. Remember that the only data that needs to encoded in the QR code is the product SKU.

![Alt text](/resources/4.png?raw=true)

Here you have two options. A single click will let you choose an action swiping left and right, via voice command will let you choose an action also. The action you need to call is "Start shopping"

![Alt text](/resources/5.png?raw=true)

While reading the code you will see some blinking points on the display. Once the QR Code is read, a "beep" sound will be played. The image will be freezed few seconds (1 or 2) while the code is processed on the device.

![Alt text](/resources/6.png?raw=true)

Once the product is gathered from Sphere.io API, the product detail information is displayed on the screen. The first time you load a new product the image retrieval could last a while, but don’t worry, next times, if the same image is needed the load will be faster because it remains cached on the app. From here you have two options, swipe down to close the screen and scan another QR code or long press to buy the product.

![Alt text](/resources/7.png?raw=true)

If you decide to buy the product a loading screen will appear. On this screen some API request will be done: create a cart, add the product to the cart, create order from cart and change order status to paid. Once this requests are answered from the API, the message “Purchase completed” will appear and will remain 1 second on the screen. Then the QR code scan screen will appear again.

###Error Handling
Two kind of errors could be displayed while using the app. The first one is a connection error produced by any reason related with connectivity, like a weak wifi connection.
The other error could happen when reading the QR Code. If the data provided by the code does not match any product on the API, it is not possible to show any information.
￼In both cases an error screen is shown, it could be closed by swiping down on the glasses device. Automatically the previous screen will be shown.

![Alt text](/resources/8.png?raw=true)

## Development

You can use your IDE to compile and install the sample or use
[`adb`](https://developer.android.com/tools/help/adb.html)
on the command line:

```bash
$ adb install -r SphereGlassesApp.apk
```
To uninstall the app, use the followong command.
```bash
adb uninstall com.sphere.io.glass
```
