<template>
  <v-list>
    <v-list-item
        variant="plain"
    >
      <v-list-item-title append-icon="people_alt">
        <v-icon icon="people_alt" class="mr-3"/>
        Клиенты
      </v-list-item-title>
    </v-list-item>

    <v-list-item

        variant="plain"
        active-color="primary"
    >
      <v-list-item-title>
        <v-icon icon="calendar_month" class="mr-3"/>
        Раписание
      </v-list-item-title>
    </v-list-item>


    <div v-if="profile.role === 'ADMIN'">
      <v-divider></v-divider>
      <v-list-subheader>Панель администратора</v-list-subheader>

      <v-list-item
          active-color="primary"
          variant="plain"
      >

        <v-list-item-title>
          <v-icon icon="manage_accounts" class="mr-3"/>
          <router-link to="/users" class="title">Пользователи</router-link>
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