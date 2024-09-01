This repro shows an issue with controlled inputs using reagent 1.2.0 and react 18.

Inputs of type `:email` and `:number` exhibit the [controlled-input cursor bug](https://github.com/reagent-project/reagent/blob/master/doc/ControlledInputs.md): as you type, the cursor will always reappear at the end end of the input. Inputs of type `:text` and `:password` don't exhibit this behavior.

To try, run `npx shadow-cljs watch dev` and open http://localhost:4444/
