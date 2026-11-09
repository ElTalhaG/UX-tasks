# Repo 1 — UI og komponenter med Compose

Dette er en forenklet undervisningsudgave af Shop Compare. Projektets KMP-/Gradle-struktur og design system er bevaret, mens funktionalitet, der ikke bruges i øvelse 1, er fjernet.

## Appen
Appen åbner direkte på én skærm. Appens startskærm er `HomeScreen.kt`, og dens indhold er ét `ItemCard` med et eksempelprodukt — der er **ikke** et søgefelt, login eller backend. Kaldet til bundmenuen i `HomeScreen.kt` er kommenteret ud, så appen starter uden en bundmenu. De studerende kan arbejde med selve komponenten i `BottomNavBar.kt` og derefter fjerne kommentarerne i skærmen.

## Opgaver

1. **Design System:** Undersøg `ui/theme/Color.kt` og `Theme.kt`. Find primærfarven, og se hvordan den eksponeres gennem `MaterialTheme.colorScheme.primary`.
2. **ItemCard og State Hoisting:** Færdiggør `ui/components/ItemCard.kt`. Tilføj en `IconButton` med et hjerte. Brug `isFavorite` til at vælge ikon/farve, og kald `onFavoriteClick()` ved tryk. Komponenten må ikke selv ændre favorit-state; den ejes af `HomeScreen` og sendes videre som parameter.
3. **Bundmenu:** Implementér `ui/components/BottomNavBar.kt` med `NavigationBar` og `NavigationBarItem` for Hjem, Søg og Lister. Fremhæv det valgte faneblad med appens primærfarve.
4. **Freestyle:** Byg eventuelt et ekstra komponent, og afprøv det med en `@Preview`, hvis det er understøttet i jeres IDE-setup.

## Projektets afgrænsning
Login/auth, øvrige skærme, app graph, repositories, DTO'er, modeller og netværkskode, der ikke bruges i denne øvelse, er fjernet fra `commonMain`. Den overordnede KMP-/Gradle- og platformopsætning samt temaet er bevaret.
