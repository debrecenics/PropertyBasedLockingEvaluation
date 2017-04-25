# Property Based Locking Evaluation (MODELS2017 Conference)

## Abstract

Large-scale model-driven engineering projects are carried out collaboratively. Enabling a high degree of concurrency is required to make the traditionally rigid development processes more agile. The increasing number of collaborators increases the probability of introducing conflicts which need to be resolved manually by the collaborators. In case of highly interdependent models, avoiding conflicts by the use of locks can save valuable time. However, traditional locking techniques such as fragment-based and object-based strategies may impose
unnecessary restrictions on editing, which can decrease the efficiency of collaboration.

We realized a property-based locking approach that generalizes traditional locking techniques, and further allows more fine-grained locks in order to restrict modifications only when necessary. A lock is considered to be violated if a match appears or disappears for its associated graph pattern (formula), which captures the property of the model that the upcoming edit transaction can be freely executed.

## How to 




