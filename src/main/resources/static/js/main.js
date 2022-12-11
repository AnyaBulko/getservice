import {createApp} from 'vue'
import App from 'pages/App.vue'
import store from "./store/store";

// Vuetify
import 'vuetify/styles'
import {createVuetify} from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import 'material-design-icons-iconfont/dist/material-design-icons.css' // Ensure your project is capable of handling css files
import {aliases, md} from 'vuetify/iconsets/md'

import UserList from "components/UserList.vue";
import Auth from "./pages/Auth.vue";


import {createWebHistory, createRouter} from "vue-router"


const routes = [
    {path: '/users', component: UserList},
    {path: '/auth/login', component: Auth},

]

const router = createRouter({
    history: createWebHistory(),
    routes,
});

const vuetify = createVuetify({
    components,
    directives,
    theme: {
        defaultTheme: 'dark'
    },
    icons: {
        defaultSet: 'md',
        aliases,
        sets: {
            md,
        },
    }
})

createApp(App).use(router).use(vuetify).use(store).mount('#app')

