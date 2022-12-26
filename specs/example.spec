Getting Started with Gauge
==========================

This is an executable specification file. This file follows markdown syntax. Every heading in this file denotes a scenario. Every bulleted point denotes a step.
To execute this specification, use `mvn test`

SENARYO 1
------------------------------

* Uygulamanın acıldığı kontrol edilir.
* Bildirim ekrani Allow secenegi ile gecilir.
* Alt menuden Book tabina gecis yapilir.
* Seyehat tipi olarak One Way secilir.
* Kalkis havaalani olarak Berlin secilir.
* Varis havaalani olarak Istanbul secilir.
* (Bugunun tarihi + 7 gün) olarak bir gidis tarihi secilir.
* Economy class secenegine tiklanir
* Ucus secim ekranının geldiği kontrol edilir
* Rastgele bir ucus secilir.
* Ucus secim ekranındaki ucus saati ile ucus detayları ekranındaki ucus saati değeri aynı mı kontrol edilir