<template>
  <v-list>
    <v-list-item
        active-color="primary"
        variant="plain"
    >
      <v-list-item-title>
        <v-btn variant="text"><span class="material-icons-round">people_alt</span></v-btn>
        Клиенты
      </v-list-item-title>
    </v-list-item>

    <v-list-item
        active-color="primary"
        variant="plain"
    >
      <v-list-item-title>
        <v-btn variant="text"><span class="material-icons-round">calendar_month</span></v-btn>
        Раписание
      </v-list-item-title>
    </v-list-item>


    <div v-if="profile.authorities.find((i) => i.authority === 'user:write')">
      <v-divider></v-divider>
      <v-list-subheader>Панель администратора</v-list-subheader>

      <v-list-item
          active-color="primary"
          variant="plain"
      >
        <v-list-item-title>
          <v-btn variant="text"><span class="material-icons-round">manage_accounts</span></v-btn>
          <router-link to="/users">Пользователи</router-link>
        </v-list-item-title>
      </v-list-item>
    </div>

  </v-list>
</template>

<script>
export default {
  name: "SidePanel",
  computed: {
    profile() {
      return this.$store.state.profile
    }
  }
}
</script>

<style scoped>

</style>