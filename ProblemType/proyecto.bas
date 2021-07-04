*GenData(1) *GenData(2) *GenData(3) *GenData(4)
*Set Cond Dirichlet_X *nodes
*set var NDX=CondNumEntities(int)
*Set Cond Dirichlet_Y *nodes
*set var NDY=CondNumEntities(int)
*Set Cond Dirichlet_Z *nodes
*set var NDZ=CondNumEntities(int)
*Set Cond Neumann *nodes
*set var NN=CondNumEntities(int)
*npoin *nelem *NDX *NDY *NDZ *NN

Coordinates
*set elems(all)
*loop nodes
*NodesNum *NodesCoord(1,real) *NodesCoord(2,real) *NodesCoord(3,real)
*end nodes
EndCoordinates

Elements
*loop elems
*ElemsNum *ElemsConec
*end elems
EndElements

Dirichlet_X
*Set Cond Dirichlet_X *nodes
*loop nodes *OnlyInCond
*NodesNum *cond(W_x,real)
*end nodes
EndDirichlet_X

Dirichlet_Y
*Set Cond Dirichlet_Y *nodes
*loop nodes *OnlyInCond
*NodesNum *cond(W_y,real)
*end nodes
EndDirichlet_Y

Dirichlet_Z
*Set Cond Dirichlet_Z *nodes
*loop nodes *OnlyInCond
*NodesNum *cond(W_z,real)
*end nodes
EndDirichlet_Z

Neumann
*Set Cond Neumann *nodes
*loop nodes *OnlyInCond
*NodesNum *cond(dWdn,real)
*end nodes
EndNeumann