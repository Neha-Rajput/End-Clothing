package com.app.endclothing.arch

interface IView<S: IState> {
    fun render(state: S)
}