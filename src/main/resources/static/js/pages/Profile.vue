<template>
  <v-row>
    <v-col>
      <v-container>
        <v-card rounded="lg">

          <v-row no-gutters>
            <v-col cols="8">
              <v-card-item class="ma-4">
                <template v-slot:prepend>
                  <v-avatar
                      color="primary" size="x-large">
                    <v-icon icon="account_circle"/>
                  </v-avatar>
                </template>
                <v-card-title>{{ profile.name }}</v-card-title>
              </v-card-item>
            </v-col>

            <v-col cols="4">
              <v-btn class="ma-8" variant="plain" @click="$router.push($route.path + '/edit')">Редактировать</v-btn>
            </v-col>
          </v-row>


          <v-divider/>

          <v-list class="ma-4">

            <v-list-item class="pb-4">
              <v-list-item-subtitle>Электронная почта</v-list-item-subtitle>
              <v-list-item-title>{{ profile.email }}</v-list-item-title>
            </v-list-item>

            <v-list-item class="pb-4">
              <v-list-item-subtitle>Телефон</v-list-item-subtitle>
              <v-list-item-title>{{ profile.number }}</v-list-item-title>
            </v-list-item>

            <v-list-item class="pb-4">
              <v-list-item-subtitle>Адрес</v-list-item-subtitle>
              <v-list-item-title>{{ profile.address }}</v-list-item-title>
            </v-list-item>

          </v-list>
        </v-card>
      </v-container>

      <v-card>asd</v-card>
      <v-card>asd</v-card>
    </v-col>
    <v-col
    >
      <v-card>asd</v-card>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "Profile",
  computed: {
    profile() {
      return this.$store.state.profile
    }
  }
}
</script>

<style scoped>

</style>