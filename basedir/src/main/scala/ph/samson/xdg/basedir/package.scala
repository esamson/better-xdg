/*
 * Copyright (C) 2020  Edward Samson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ph.samson.xdg

import better.files.File

package object basedir {

  def data(base: String) = new DataResolver(base)

  def config(base: String) = new ConfigResolver(base)

  def cache(base: String) = new CacheResolver(base)

  def runtime(base: String) = new RuntimeResolver(base)

  @scala.annotation.tailrec
  private[basedir] def resolve(resolved: File, fragments: Seq[String]): File = {
    if (fragments.isEmpty) {
      resolved
    } else {
      resolve(resolved / fragments.head, fragments.tail)
    }
  }
}
