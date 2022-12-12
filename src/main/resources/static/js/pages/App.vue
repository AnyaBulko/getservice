<template>
  <v-app>

    <v-app-bar>
      <v-app-bar-title @click="this.$router.push('/')">GetService</v-app-bar-title>
      <v-spacer></v-spacer>
      <v-btn v-if="profile" variant="plain" :disabled="$route.path === '/profile'" @click="showProfile">{{ profile.name }}</v-btn>
      <v-btn v-if="!profile" href="/auth/login">Войти</v-btn>
      <form v-else class="px-4" action="/auth/logout" method="POST">
        <v-btn type="submit" color="primary" append-icon="logout" >Выйти</v-btn>
      </form>
    </v-app-bar>

    <v-navigation-drawer v-if="profile">
      <v-card>
        <side-panel ></side-panel>
      </v-card>
    </v-navigation-drawer>

    <v-main>
      <v-container>
          <router-view></router-view>
      </v-container>

    </v-main>
  </v-app>


</template>

<script>
import SidePanel from "../components/SidePanel.vue";

export default {
  components: {

    SidePanel
  },
  computed: {
    profile() {
      return this.$store.state.profile
    }
  },
  methods: {
    showProfile() {
      this.$router.push('/profile')
    }
  }
}
</script>

<style>

</style>
