# Evaluation of Property Based Locking 
Property-based Locking in Collaborative Modeling (MODELS2017 Conference)

## Abstract

Large-scale model-driven engineering projects are carried out collaboratively. Enabling a high degree of concurrency is required to make the traditionally rigid development processes more agile. The increasing number of collaborators increases the probability of introducing conflicts which need to be resolved manually by the collaborators. In case of highly interdependent models, avoiding conflicts by the use of locks can save valuable time. However, traditional locking techniques such as fragment-based and object-based strategies may impose
unnecessary restrictions on editing, which can decrease the efficiency of collaboration.

We realized a property-based locking approach that generalizes traditional locking techniques, and further allows more fine-grained locks in order to restrict modifications only when necessary. A lock is considered to be violated if a match appears or disappears for its associated graph pattern (formula), which captures the property of the model that the upcoming edit transaction can be freely executed.

## How to Setup the Evaluation

The `implementation` folder contains the realization of property-based locking strategy and the `evaluation` folder includes infrastructure to generate models and evaluate locks defined in fragment-based, object-based and property-based locking strategies.

### Implementation

* Requirements
  * Xtext 2.10 ([updatesite](http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/))
  * Xtend 2.10 ([updatesite](http://download.eclipse.org/modeling/tmf/xtext/updates/composite/releases/))
  * Viatra 2.11 ([updatesite](http://download.eclipse.org/viatra/updates/release))
  * Viatra Obfuscator ([updatesite](http://download.eclipse.org/viatra/modelobfuscator/updates/integration))

* Build Access Control Language for Rules - org.mondo.collaboration.security.macl.xtext.rule
    * Add `src-gen` folder to fix build path error.
    * Run `GenerateMACLRule.mwe2` as "MWE2 Workflow"
* Build Access Control Language - org.mondo.collaboration.security.macl.xtext
    * Add `src-gen` folder to fix build path error.
    * Run `GenerateMondoAccessControlLanguage.mwe2` as "MWE2 Workflow"
* Build Property-based Locking Language - org.mondo.collaboration.security.mpbl.xtext
    * Add `src-gen` folder to fix build path error.
    * Run `GenerateMondoPropertyBasedLocking.mwe2` as "MWE2 Workflow"
* Build Security Collaboration Lens Implementation - org.mondo.collaboration.security.lens
    * Add `src-gen` folder to fix build path error.
    * Build the project to generate `.java` files from `.xtend` classes.

### Evaluation

In the `*.meta` plugin project, open the `*.genmodel` file and generate the model code: in the tree-editor, right click on the root object and select the `Generate Model`.

In the `*.query` plugin project, open the `*.vql` file and force to build the associated artifacts.

#### Generate Models

* In the `*.generator` plugin project, the `Generators.java` file has a `main` method that can be run. 
* Modify the `generateModels()` method to select the output folder.
    * Modify the `users` array to set the number of collaborators.
    * Modify the `fragments` array to set the number of fragments.
    * Modify the `depths` variable to set the depth of each fragments.

## Execute Evaluation

* In the `*.eval` plugin project, the `Evaluation.java` file has a `main` method that can be run.
    * Modify the `users` array to set the number of collaborators.
    * Modify the `fragments` array to set the number of fragments.
    * Modify the `depths` array to set the depth of each fragments.
    * Modify the `repeat` variable to set how many times run each evalution.
    
