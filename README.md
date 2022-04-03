# SFMproject

## Bevezetés

## Github repo használata:
A Trello táblát [itt](https://trello.com/b/n0FfYfjf/szoftver-fejleszt%C3%A9s) lehet megnézni. 
1. letöltjük a repositoryt ```git clone https://github.com/zorrrozotya/SFMproject.git``` Frissítéshez: ```git pull``` parancs.
2. A Trelloról kiválasztasz egy feladatot.
3. Csinálsz egy új branchet a github felületén aminek a nevében benne van az adott kártya neve amit választottál pl.: ```feature/card-2-implement-proper-main-menu```.
4. A terminálba ```git checkout "branch neve"``` azzal lépsz be az új branchbe és ezzel a parancsal is lehet visszalépni. 
5. Megcsinálod a kódolást.
6. kijelölöd a fájlokat amiket commitolni akarsz ```git add .```
7. Commitolod a változtatásokat ```git commit -m "ide írd hogy milyen változtatások vannak a commitba vagy az adott kártya neve"```
8. Feltölteni githubra ``` git push origin "branch neve"```
9. A github felületén nyitsz egy új pull requestet és ha valaki elfogadja akkor lehet mergelni
10. Saját branched legfrissebb masterre frissítése:
  VS code editorban csináld hogy a conflict feloldás ne legyen szívás = beíroda a project mappájában a cmd-be hogy ```code .``` majd ```git checkout master``` majd ```git pull``` majd ```git checkout saját-branched``` majd ```git rebase -i master``` aztán bezárod a filet feloldod a conflictokat(accept incoming change)majd ```git add .``` és ```git rebase --continue``` és kész is van :D
