<template>
  <v-app>

    <v-app-bar title="GetService">
      <v-spacer></v-spacer>
      <v-btn v-if="!profile" href="/auth/login">Войти</v-btn>

      <form v-else class="px-4" action="/auth/logout" method="POST">
        {{ profile.username }}
        <v-btn type="submit" color="primary" append-icon="logout" class="ml-6">Выйти</v-btn>
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
  }
}
</script>

<style>

</style>
