![AndroILD Logo](AndroILD.png)

An Image Loading delegate to common Android Image Loading Libraries

## API

~~~kotlin
// For drawable resources
AndroILD.newRequest()
    .load(R.drawable.logo)
    .into(imageView)

// For network resources
AndroILD.newRequest()
    .load("https://github.com/sriharshachilakapati/AndroILD/raw/main/AndroILD.png")
    .into(imageView)
~~~

Maven URLs will be given once the API becomes stable.