# DNA Sequencer

A Java program that validates and assembles DNA strands into a complete DNA molecule by finding the longest common sequences between fragments.

## Features
- Validates DNA strands (only accepts A, G, T, C characters)
- Finds longest common subsequences between DNA fragments
- Assembles fragments into a single DNA molecule
- Requires minimum 4-character overlap for merging

## Usage
```bash
javac DNASequencer.java
java DNASequencer <strand1> <strand2> ...
```

## Example
```bash
java DNASequencer ATCG GCTA TACG
```

**Author:** Giorgos Fotiou  
**Last Updated:** 09/10/2023
