## Reddit avec une version simplifié 

![Capture](/uploads/18d689185c4ec48f00c5f9e8a78c3ace/Capture.JPG)

**Version 1.0.0** 

Dans ce projet, on a réaliser un forum de discussion (comme Reddit), dont lequelle les utilisateurs peuvent créer leurs propres sujets de discussion avec un titre et une description. Ils peuvent aussi commenter à un sujet ou un commentaire et voter sur les autres sujets ou commentaire. Si jamais un utilisateur oublie son mot de passe, il peut faire un mot de passe oublié pour changer son mot de passe.

Le site affiche les sujets et les commentaires par ordre décroissant sur la quantité nombre votes.
Pour chaque utilisateur, le site permet d'accéder à la liste de ses commentaires et de ses sujets de discution du plus récent au plus ancien.

Il existe trois types d'utilisatuers:
- Utilisateur non authentifié (Visiteur) : Il peut seulement visiter le site et voir les sujets proposé sans avoir la possibilité de commenter ou créer des sujets ou voter.
- Utilisateur authentifié : Il peut bénéficier de tout les avantages du forum, commenter, créer des sujets et voter et aussi supprimer son commentaire.
- Admin : En plus des possibilités d'un utilisateur normal, il peut supprimer des sujets de discussion (et tous les commentaires qui s'y rapporte).

Pour lancer l'application, vous devez lancer le serveur et accéder à l'URL : http://localhost:8080/ .

Il existe 2 utilisateurs déjà inscrit pour tester http://localhost:8080/login : .
User : admin , Pass : admin
User : prof , Pass : prof

![Capture](/uploads/d640e4fa441c86e0aff2fcd063ef1e50/Capture.JPG)

---

### Technologies :
---

Dans ce projet, on a utilisé SpringBoot pour la configuration de spring, SpringMVC pour le controlleur, Spring Secuirty pour l'authentification.
Pour la base de données, on a utilisé MySQL AWS et hibernate.
Pour la récupération de mot de passe, on a utilisé JavaMail (Javax.Mail), il reçoit dans son mail un lien pour changer le mot de passe.

### Difficultés :
---

Les difficultés qu'on a rencontré c'est le fonctionnement des commentaires, comment un utilisateur peut commenter à un autre commentaire à un autre commentaire, on a gérer ce problèmes on utilisant JavaScript.

### Conclusion : 
---

La réalisation de ce projet nous a appris beaucoup de nouvelles choses. Malgré les difficultés qu’on a pu surmonter, ceci nous a permis de mieux comprendre chaque étape du projet, et bien maitrisé Spring et Hibernate en général.

### Contributeurs : 
---
- [Driss NFIFI]
- [Imad JANATI-IDRISSI]
- [Khalil BAKRI]
- [Saad ZRIDI]

### License & copyright :
--- 
:copyright: 2021 . All rights reserved. 


1-hide password for database in application.proprities
2-list of subject without comments
3-add vote
4-list comment 5 by 5 
5-send message to email 