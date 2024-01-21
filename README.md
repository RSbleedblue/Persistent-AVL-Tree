# Persistent AVL Tree

## Overview

An AVL tree is a self-balancing binary search tree where the balance factor of each node is maintained within a specified range. This ensures that the height of the left and right subtrees of any node differs by at most one, leading to logarithmic time complexity for basic operations like insertion, deletion, and search.

This project introduces the concept of a **Persistent AVL Tree**, which is a persistent data structure. In the context of this implementation, a persistent AVL tree retains access to previous versions of itself, even after undergoing modifications. After each insertion or deletion operation, the previous version of the tree is preserved, and a new version is created to reflect the changes.

## Key Features

- **AVL Tree Functionality**: The underlying AVL tree ensures self-balancing, providing efficient performance for search, insertion, and deletion operations.

- **Persistence**: The Persistent AVL Tree retains access to previous versions, allowing users to access historical states of the tree.

## How to Use

1. **Instantiate the Persistent AVL Tree**:

    ```java
    AvlDS persistentAvlTree = new AvlDS();
    ```

2. **Insert Data**:

    ```java
    persistentAvlTree.insert(5);
    persistentAvlTree.insert(3);
    persistentAvlTree.insert(7);
    // ... additional insertions
    ```

3. **Delete Data**:

    ```java
    persistentAvlTree.delete(3);
    persistentAvlTree.delete(6);
    // ... additional deletions
    ```

4. **Access Versions**:

    ```java
    HashMap<Integer, Tree> versions = persistentAvlTree.getVersions();
    ```

5. **Retrieve Specific Version**:

    ```java
    Tree version3 = persistentAvlTree.getByVersions(3);
    ```

## Important Notes

- **Balancing**: The AVL tree automatically maintains balance during insertions and deletions.

- **Persistence**: The `getVersions` method provides access to all versions of the AVL tree.

- **Retrieval**: The `getByVersions` method allows users to retrieve a specific version of the tree.

## Contributors

-- Rivansh Srivatava
