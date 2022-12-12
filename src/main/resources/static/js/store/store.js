import { createStore } from 'vuex'

const store = createStore({
    state () {
        return {
            users: frontendData.users,
            profile: frontendData.profile
        }
    }
})

export default store