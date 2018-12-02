# Redlit - lightweight copy of reddit
Web-application imitating reddit backed system.
Each webAPI is written using Spring MVC framework.

Usage:
Run the application.
Send HTTP request towards `http://localhost:8080` i.e:
`http://localhost:8080/r/lol/bekapost`

## redlits
Application handling reddit functions `/r...` - posting threads, posts and comments.
Uses NOSQL MongoDB hosted on Azure Cloud.

## users
Application handling reddit functions `/u...` - CRUD operations on users
Uses SQL DB hosted on Azure Cloud.

## security
Basic auth on all HTTP calls, based on login and password from `users` SQL DB.