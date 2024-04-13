
# Huffman Coding for Image Compression

This project implements Huffman coding for image compression. This was part of the internal evaluation for the Design and Analysis of algorithms course. Huffman coding is a lossless data compression algorithm that assigns variable-length codes to characters based on their frequency of occurrence in the data. By using shorter codes for more frequent characters, Huffman coding can achieve significant compression ratios.


## Getting Started
To get started with the project, follow these steps:
1. Clone the repository to your local system using the following command:

```git clone https://github.com/AkhileshP06/Design-and-Analysis-of-Algorithms.git```

2. Navigate to the huffman-coding directory:

```cd huffmanCoding```

3. Compile the Java files using the following command:

```javac *.java```

4. Run the HuffmanCompression class using the java command:

```java HuffmanCompression```




## Project Structure
The project has the following structure:
- src: Contains the Java implementation of Huffman coding.
    - HuffmanCoding.java: The main class that implements Huffman coding for image compression.
    - HuffmanNode.java: Represents a node in the Huffman tree.
    - HuffmanTree.java: Represents the Huffman tree.
    - ImageCompressor.java: Implements the image compression using Huffman coding.
    - ImageDecompressor.java: Implements the image decompression using Huffman coding.
    - Utils.java: Contains utility methods used in the project.
- images: Contains the input and output images used in the project.
## Usage
To compress an image using Huffman coding, follow these steps:

1. Place the input image in the images directory.
2. Run the HuffmanCoding class using the java command:
```java HuffmanCoding```

3. The compressed image will be saved in the images directory with the prefix compressed_.

To decompress a compressed image, follow these steps:

1. Place the compressed image in the images directory.
2. Run the ImageDecompressor class using the java command:
```java ImageDecompressor```
3. The decompressed image will be saved in the images directory with the prefix decompressed_.

## Contributing

Contributions are always welcome!

If you would like to contribute to the project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your changes.
3. Make your changes and commit them to your branch.
4. Create a pull request.


## Authors

- [@Amalkrishnaaa](https://github.com/Amalkrishnaaa)
- [@Karthick-7014](https://github.com/Karthick-7014)

